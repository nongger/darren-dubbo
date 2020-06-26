package com.darren.dubbo.provider.config;

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
//        application.setName("darren-dubbo-provider");
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
//        protocol.setPort(9001);
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
//    public ServiceConfig serviceConfig(ApplicationConfig applicationConfig, RegistryConfig registryConfig, ProtocolConfig protocolConfig, UserService userService) {
//
//        // 注意：ServiceConfig为重对象，内部封装了与注册中心的连接，以及开启服务端口
//        // 服务提供者暴露服务配置
//        ServiceConfig<UserService> service = new ServiceConfig<UserService>(); // 此实例很重，封装了与注册中心的连接，请自行缓存，否则可能造成内存和连接泄漏
//        service.setApplication(applicationConfig);
//        service.setRegistry(registryConfig); // 多个注册中心可以用setRegistries()
//        service.setProtocol(protocolConfig); // 多个协议可以用setProtocols()
//        service.setInterface(UserService.class);
//        service.setRef(userService);
//        service.setVersion("1.0.0");
//
//        // 暴露及注册服务
//        service.export();
//        return service;
//    }
}
