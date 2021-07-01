package com.coco.naruto.arms.order.service;

import com.coco.naruto.api.arms.user.api.UserServiceApi;
import com.coco.naruto.api.arms.user.dto.UserDTO;
import com.coco.naruto.arms.order.pojo.OrderDO;
import com.coco.naruto.arms.order.mapper.OrderMapper;
import javax.annotation.Resource;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * @author chuanzhang
 * @description TODO
 * @date 2021/6/21
 */
@Service
public class OrderServiceImpl implements OrderService{

    @DubboReference(version = "1.0.0", url = "dubbo://127.0.0.1:12345")
    private UserServiceApi userServiceApi;
    @Resource
    private OrderMapper orderMapper;

    @Override
    public OrderDO queryOrderDetail(String orderNo) {
        UserDTO userDTO = userServiceApi.queryUserDetail(1L);
        String userName = userDTO.getUserName();
        OrderDO orderDO = orderMapper.queryOrderDetail(orderNo);
        orderDO.setUserName(userName);
        return orderDO;
    }
}
