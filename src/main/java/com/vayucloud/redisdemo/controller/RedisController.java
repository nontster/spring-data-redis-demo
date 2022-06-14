package com.vayucloud.redisdemo.controller;

import com.vayucloud.redisdemo.model.RedisInfo;
import com.vayucloud.redisdemo.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    Logger logger = LoggerFactory.getLogger(RedisController.class);
    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json; charset=utf8")
    public Object register(@RequestBody RedisInfo redisInfo) {
        redisService.addKey(redisInfo.getKey(), redisInfo.getValue());
        logger.info(redisInfo.toString());
        return redisInfo;
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST, produces = "application/json; charset=utf8")
    public Object get(@RequestBody RedisInfo redisInfo) {
        String value = redisService.getValue(redisInfo.getKey());
        redisInfo.setValue(value);
        logger.info(redisInfo.toString());
        return redisInfo;
    }
}
