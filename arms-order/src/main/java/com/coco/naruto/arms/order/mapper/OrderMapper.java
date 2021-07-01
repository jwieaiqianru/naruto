package com.coco.naruto.arms.order.mapper;

import com.coco.naruto.arms.order.pojo.OrderDO;
import org.apache.ibatis.annotations.Param;

/**
 * @author chuanzhang
 * @description TODO
 * @date 2021/6/21
 */
public interface OrderMapper {


    OrderDO queryOrderDetail(@Param("orderNo") String orderNo);
}
