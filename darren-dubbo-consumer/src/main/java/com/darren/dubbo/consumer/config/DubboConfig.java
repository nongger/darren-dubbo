package com.darren.dubbo.consumer.config;

import org.springframework.context.annotation.Configuration;

/**
 * Project: darren-dubbo
 * Author : Eric
 * Time   : 2020-06-21 16:19
 * Desc   : dubbo的配置类方式的写法
 */
@Configuration
public class DubboConfig {

//    @Bean
//    public ApplicationConfig applicationConfig() {
//        // 当前应用配置
//        ApplicationConfig application = new ApplicationConfig();
//        application.setName("darren-dubbo-consumer");
//        return application;
//    }
//
//    @Bean
//    public RegistryConfig registryConfig() {
//        // 连接注册中心配置
//        RegistryConfig registry = new RegistryConfig();
//        registry.setProtocol("zookeeper");
//        registry.setAddress("127.0.0.1:2181");
//        return registry;
//    }
//
//    @Bean
//    public ProtocolConfig protocolConfig() {
//        // 服务提供者协议配置
//        ProtocolConfig protocol = new ProtocolConfig();
//        protocol.setName("dubbo");
//        protocol.setPort(9002);
//        protocol.setThreads(200);
//        return protocol;
//    }
//
//    @Bean
//    public MonitorConfig monitorConfig() {
//        MonitorConfig monitorConfig = new MonitorConfig();
//        monitorConfig.setProtocol("registry");
//        return monitorConfig;
//    }
//
//    @Bean
//    public UserService userService(ApplicationConfig applicationConfig, RegistryConfig registryConfig) {
//        // 注意：ReferenceConfig为重对象，内部封装了与注册中心的连接，以及与服务提供方的连接
//
//        // 引用远程服务
//        ReferenceConfig<UserService> reference = new ReferenceConfig<UserService>(); // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
//        reference.setApplication(applicationConfig);
//        reference.setRegistry(registryConfig); // 多个注册中心可以用setRegistries()
//        reference.setInterface(UserService.class);
//        reference.setVersion("1.0.0");
//
//        // 和本地bean一样使用xxxService
//        // 注意：此代理对象内部封装了所有通讯细节，对象较重，请缓存复用
//
//        return reference.get();
//    }
}
