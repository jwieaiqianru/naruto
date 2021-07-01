package com.coco.naruto.arms.user.service;

import com.coco.naruto.arms.user.pojo.UserDO;

/**
 * @author chuanzhang
 * @description TODO
 * @date 2021/6/21
 */
public interface UserService {


    UserDO queryUserDetail(Long userId);
}
