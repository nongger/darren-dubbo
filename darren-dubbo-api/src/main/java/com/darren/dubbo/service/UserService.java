package com.darren.dubbo.service;


import com.darren.dubbo.UserAddress;

import java.util.List;

/**
 * Project: darren-dubbo
 * Author : Eric
 * Time   : 2020-06-20 23:35
 * Desc   :  *
 */
public interface UserService {

    /**
     * 按照用户id返回所有的收货地址
     *
     * @param userId
     * @return
     */
    List<UserAddress> getUserAddressList(String userId);

}
