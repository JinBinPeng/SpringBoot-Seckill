package com.pjb.springbootseckill.rabbitmq;

import com.pjb.springbootseckill.domain.MiaoshaUser;
import lombok.Data;

@Data
public class MiaoshaMessage {
    private MiaoshaUser user;
    private long goodsId;
}
