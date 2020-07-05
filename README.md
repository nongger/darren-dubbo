本文通过学习Dubbo官方文档，通过开发demo了解Dubbo的基本原理和用法 [文章源码地址](https://github.com/nongger/darren-dubbo)
![服务架构](https://upload-images.jianshu.io/upload_images/20792523-e759c312aaf4808f.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

###调用关系说明
0. 服务容器负责启动，加载，运行服务提供者。
1. 服务提供者在启动时，向注册中心注册自己提供的服务。
2. 服务消费者在启动时，向注册中心订阅自己所需的服务。
3. 注册中心返回服务提供者地址列表给消费者，如果有变更，注册中心将基于长连接推送变更数据给消费者。
4. 服务消费者，从提供者地址列表中，基于软负载均衡算法，选一台提供者进行调用，如果调用失败，再选另一台调用。
5. 服务消费者和提供者，在内存中累计调用次数和调用时间，定时每分钟发送一次统计数据到监控中心。

### 重写与优先级
优先级从高到低：

1. JVM -D参数，当你部署或者启动应用时，它可以轻易地重写配置，比如，改变dubbo协议端口；
2. XML, XML中的当前配置会重写dubbo.properties中的；
3. Properties，默认配置，仅仅作用于以上两者没有配置时。
>如果在classpath下有超过一个dubbo.properties文件，比如，两个jar包都各自包含了dubbo.properties，dubbo将随机选择一个加载，并且打印错误日志。

![配置的加载顺序](https://upload-images.jianshu.io/upload_images/20792523-94538693afc44867.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

### 不同粒度配置的覆盖关系
以 timeout 为例，下图显示了配置的查找顺序，其它 retries, loadbalance, actives 等类似：

方法级优先，接口级次之，全局配置再次之。
如果级别一样，则消费方优先，提供方次之。
其中，服务提供方配置，通过 URL 经由注册中心传递给消费方。
![配置的覆盖关系](https://upload-images.jianshu.io/upload_images/20792523-bb039cad21a79a96.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

## 常用配置
### 启动时检查
Dubbo 缺省会在启动时检查依赖的服务是否可用，不可用时会抛出异常，阻止 Spring 初始化完成，以便上线时，能及早发现问题，默认 check="true"。

可以通过 check="false" 关闭检查，比如，测试时，有些服务不关心，或者出现了循环依赖，必须有一方先启动。

另外，如果你的 Spring 容器是懒加载的，或者通过 API 编程延迟引用服务，请关闭 check，否则服务临时不可用时，会抛出异常，拿到 null 引用，如果 check="false"，总是会返回引用，当服务恢复时，能自动连上。
```
dubbo.reference.com.foo.BarService.check=false
dubbo.reference.check=false #强制改变所有 reference 的 check 值，就算配置中有声明，也会被覆盖。
dubbo.consumer.check=false #是设置 check 的缺省值，如果配置中有显式的声明，如：<dubbo:reference check="true"/>，不会受影响。
dubbo.registry.check=false #前面两个都是指订阅成功，但提供者列表是否为空是否报错，如果注册订阅失败时（注册中心挂掉了），也允许启动，需使用此选项，将在后台定时重试。
```
### 超时
timeout 远程服务调用超时时间(毫秒)  默认1000，可以定义全局也可以定义接口或方法维度覆盖策略参考前文
### 重试
retries 远程服务调用重试次数，不包括第一次调用，不需要重试请设为0,仅在cluster为failback/failover时有效（只能针对幂等的接口允许重试，非幂等不能重试，所以一般要设置在接口或方法级别）
### 多版本控制
当一个接口实现，出现不兼容升级时，可以用版本号过渡，版本号不同的服务相互间不引用。
可以按照以下的步骤进行版本迁移：
1. 在低压力时间段，先升级一半提供者为新版本
2. 再将所有消费者升级为新版本
3. 然后将剩下的一半提供者升级为新版本
```
在提供方标记提供的服务版本号。
在消费方标明要引用的版本号，如不需要区分版本用*表示。
@Service(version = "1.0.0") 
```
### 直连方式
```
// 点对点直连方式，将以服务接口为单位，忽略注册中心的提供者列表，A 接口配置点对点，不影响 B 接口从注册中心获取列表（通常在测试阶段使用，线上不建议）。
@Reference(url = "127.0.0.1:9001")
```
## 负载均衡策略
```
Dubbo提供了4种LoadBalance的实现（默认random），我们也可以自己实现一个负载策略。
@Reference(loadbalance = "random", timeout = 1000)
```
![LoadBalance实现类](https://upload-images.jianshu.io/upload_images/20792523-8c92c1331b0aa82e.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

### Random LoadBalance

*   **随机**，按权重设置随机概率。
*   在一个截面上碰撞的概率高，但调用量越大分布越均匀，而且按概率使用权重后也比较均匀，有利于动态调整提供者权重。

### RoundRobin LoadBalance

*   **轮询**，按公约后的权重设置轮询比率。
*   存在慢的提供者累积请求的问题，比如：第二台机器很慢，但没挂，当请求调到第二台时就卡在那，久而久之，所有请求都卡在调到第二台上。

### LeastActive LoadBalance

*   **最少活跃调用数**，相同活跃数的随机，活跃数指调用前后计数差。
*   使慢的提供者收到更少请求，因为越慢的提供者的调用前后计数差会越大。

### ConsistentHash LoadBalance

*   **一致性 Hash**，相同参数的请求总是发到同一提供者。
*   当某一台提供者挂时，原本发往该提供者的请求，基于虚拟节点，平摊到其它提供者，不会引起剧烈变动。
*   算法参见：[http://en.wikipedia.org/wiki/Consistent_hashing](http://en.wikipedia.org/wiki/Consistent_hashing)
*   缺省只对第一个参数 Hash，如果要修改，请配置 `<dubbo:parameter key="hash.arguments" value="0,1" />`
*   缺省用 160 份虚拟节点，如果要修改，请配置 `<dubbo:parameter key="hash.nodes" value="320" />`

## dubbo的原理
### 如何解析标签
基于 dubbo.jar 内的 META-INF/spring.handlers 配置，Spring 在遇到 dubbo 名称空间时，会回调 DubboNamespaceHandler。
所有 dubbo 的标签，都统一用 DubboBeanDefinitionParser 进行解析，基于一对一属性映射，将 XML 标签解析为 Bean 对象。
在 ServiceConfig.export() 或 ReferenceConfig.get() 初始化时，将 Bean 对象转换 URL 格式，所有 Bean 属性转成 URL 的参数。
### 服务暴露过程
![服务暴露](https://upload-images.jianshu.io/upload_images/20792523-0886bb6555776712.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
### 服务引用过程
![服务引用](https://upload-images.jianshu.io/upload_images/20792523-2e23434ecbeda010.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

### 服务调用过程
![服务调用](https://upload-images.jianshu.io/upload_images/20792523-bdd74f56ed5e1d1c.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
