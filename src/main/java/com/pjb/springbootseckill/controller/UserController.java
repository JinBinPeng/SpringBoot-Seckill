package com.pjb.springbootseckill.controller;

import com.pjb.springbootseckill.domain.MiaoshaUser;
import com.pjb.springbootseckill.redis.RedisService;
import com.pjb.springbootseckill.result.Result;
import com.pjb.springbootseckill.service.MiaoshaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    MiaoshaUserService userService;

    @Autowired
    RedisService redisService;

    @RequestMapping("/info")
    public Result<MiaoshaUser> info(MiaoshaUser user) {
        return Result.success(user);
    }

}
