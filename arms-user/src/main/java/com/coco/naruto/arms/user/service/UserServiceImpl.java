package com.coco.naruto.arms.user.service;

import com.coco.naruto.arms.user.pojo.UserDO;
import com.coco.naruto.arms.user.mapper.UserMapper;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author chuanzhang
 * @description TODO
 * @date 2021/6/21
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDO queryUserDetail(Long userId) {
        return userMapper.queryUserDetail(userId);
    }
}
