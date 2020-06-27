package com.darren.dubbo.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.darren.dubbo.UserAddress;
import com.darren.dubbo.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;

/**
 * Project: darren-dubbo
 * Author : Eric
 * Time   : 2020-06-21 16:38
 * Desc   :  *
 */
@Service
@Component
public class UserServiceImpl implements UserService {
    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @HystrixCommand
    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        logger.info("UserServiceImpl调用，入参userId：[{}]", userId);

        // 模拟异常
        int randomId = new SecureRandom().nextInt(10);
        if (randomId > 5) {
            logger.info("随机：{}", randomId);
            throw new RuntimeException("随机异常！");
        }

        UserAddress address1 = new UserAddress(1, "北京市昌平区宏福科技园综合楼3层", "1", "李老师", "010-56253825", "Y");
        UserAddress address2 = new UserAddress(2, "深圳市宝安区西部硅谷大厦B座3层（深圳分校）", "1", "王老师", "010-56253825", "N");

        return Arrays.asList(address1, address2);
    }

}
