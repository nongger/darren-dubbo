package com.darren.dubbo.consumer.controller;

import com.darren.dubbo.UserAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * Project: darren-dubbo
 * Time   : 2020-11-24 20:24
 * Desc   :  *
 */
@RestController
public class EncodeIssueController {
    private Logger logger = LoggerFactory.getLogger(EncodeIssueController.class);

    @RequestMapping(value = "/encodeTest", method = RequestMethod.GET)
    public String getUserId(@RequestParam("uid") String userId) {
        logger.info(userId);

        return "success";
    }

    @RequestMapping(value = "/encodePost", method = RequestMethod.GET)
    public String initOrder(@RequestBody UserAddress userAddress) {
//        logger.info(JSON.json(userAddress));

        return "success";
    }

}
