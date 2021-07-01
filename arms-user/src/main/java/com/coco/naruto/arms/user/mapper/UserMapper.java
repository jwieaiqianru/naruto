package com.coco.naruto.arms.user.mapper;

import com.coco.naruto.arms.user.pojo.UserDO;
import org.apache.ibatis.annotations.Param;

/**
 * @author chuanzhang
 * @description TODO
 * @date 2021/6/21
 */
public interface UserMapper {

    UserDO queryUserDetail(@Param("userId") Long userId);
}
