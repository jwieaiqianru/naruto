package com.coco.naruto.api.arms.user.api;

import com.coco.naruto.api.arms.user.dto.UserDTO;

/**
 * @author chuanzhang
 * @description rest user api
 * @date 2021/6/21
 */

public interface UserServiceApi {

    UserDTO queryUserDetail(Long userId);
}
