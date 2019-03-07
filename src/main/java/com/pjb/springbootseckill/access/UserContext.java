package com.pjb.springbootseckill.access;


import com.pjb.springbootseckill.domain.MiaoshaUser;

public class UserContext {
    //保证用户线程安全
    private static ThreadLocal<MiaoshaUser> userHolder = new ThreadLocal<>();

    public static void setUser(MiaoshaUser user) {
        userHolder.set(user);
    }

    public static MiaoshaUser getUser() {
        return userHolder.get();
    }

    private UserContext(){

    }

}
