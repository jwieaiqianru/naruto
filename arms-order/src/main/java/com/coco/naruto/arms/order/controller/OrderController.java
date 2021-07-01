package com.coco.naruto.arms.order.controller;

import cn.hutool.core.util.RandomUtil;
import com.coco.naruto.arms.order.pojo.OrderDO;
import com.coco.naruto.arms.order.service.OrderService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chuanzhang
 * @description TODO
 * @date 2021/6/21
 */
@RequestMapping("/order")
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/detail")
    public OrderDO getOrderDetail(@RequestParam String orderNo) throws InterruptedException {
        Thread.sleep(RandomUtil.randomInt(1,1000));
        return orderService.queryOrderDetail(orderNo);
    }

}
