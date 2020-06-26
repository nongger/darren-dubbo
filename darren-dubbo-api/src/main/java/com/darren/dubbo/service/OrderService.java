package com.darren.dubbo.service;


import com.darren.dubbo.UserAddress;

import java.util.List;

public interface OrderService {

    /**
     * 初始化订单
     *
     * @param userId
     */
    List<UserAddress> initOrder(String userId);

}
