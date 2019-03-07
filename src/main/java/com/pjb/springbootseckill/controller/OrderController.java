package com.pjb.springbootseckill.controller;

import com.pjb.springbootseckill.domain.MiaoshaUser;
import com.pjb.springbootseckill.domain.OrderInfo;
import com.pjb.springbootseckill.redis.RedisService;
import com.pjb.springbootseckill.result.CodeMsg;
import com.pjb.springbootseckill.result.Result;
import com.pjb.springbootseckill.service.GoodsService;
import com.pjb.springbootseckill.service.MiaoshaUserService;
import com.pjb.springbootseckill.service.OrderService;
import com.pjb.springbootseckill.vo.GoodsVo;
import com.pjb.springbootseckill.vo.OrderDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    MiaoshaUserService userService;

    @Autowired
    RedisService redisService;

    @Autowired
    OrderService orderService;

    @Autowired
    GoodsService goodsService;

    @RequestMapping("/detail")
    public Result<OrderDetailVo> info(MiaoshaUser user, @RequestParam("orderId") long orderId) {
        if (user == null) {
            return Result.error(CodeMsg.SESSION_ERROR);
        }
        OrderInfo order = orderService.getOrderById(orderId);
        if (order == null) {
            return Result.error(CodeMsg.ORDER_NOT_EXIST);
        }
        long goodsId = order.getGoodsId();
        GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);
        OrderDetailVo vo = new OrderDetailVo();
        vo.setOrder(order);
        vo.setGoods(goods);
        return Result.success(vo);
    }

}
