package com.pjb.springbootseckill.redis;

public interface KeyPrefix {

    int expireSeconds();

    String getPrefix();

}
