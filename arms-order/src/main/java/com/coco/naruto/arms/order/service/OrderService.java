package com.coco.naruto.arms.order.service;

import com.coco.naruto.arms.order.pojo.OrderDO;

/**
 * @author chuanzhang
 * @description TODO
 * @date 2021/6/21
 */
public interface OrderService {

    OrderDO queryOrderDetail(String orderNo);

}
