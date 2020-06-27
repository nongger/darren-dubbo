package com.darren.dubbo.consumer.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.darren.dubbo.UserAddress;
import com.darren.dubbo.service.OrderService;
import com.darren.dubbo.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Project: darren-dubbo
 * Author : Eric
 * Time   : 2020-06-20 23:35
 * Desc   :  *
 */
@Service
public class OrderServiceImpl implements OrderService {
    private static Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Reference(loadbalance = "random", timeout = 1000) //dubbo直连
    private UserService userService;

    @Override
    @HystrixCommand(fallbackMethod = "hello")
    public List<UserAddress> initOrder(String userId) {
        System.out.println("用户id：" + userId);
        //1、查询用户的收货地址
        return userService.getUserAddressList(userId);
    }


    public List<UserAddress> hello(String userId) {
        logger.error("服务出错：{}", userId);

        return Arrays.asList(new UserAddress(10, "测试地址", "1", "测试", "测试", "Y"));
    }


}
