package com.pjb.springbootseckill.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pjb.springbootseckill.redis.RedisService;
import com.pjb.springbootseckill.result.Result;
import com.pjb.springbootseckill.service.MiaoshaUserService;
import com.pjb.springbootseckill.vo.LoginVo;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    MiaoshaUserService userService;

    @Autowired
    RedisService redisService;

    @RequestMapping("/to_login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/do_login")
    @ResponseBody
    public Result<String> doLogin(HttpServletResponse response, @Valid LoginVo loginVo) {
        //登录
        String token = userService.login(response, loginVo);
        return Result.success(token);
    }
}
