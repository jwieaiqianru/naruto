package com.coco.naruto.arms.user.controller;

import com.coco.naruto.arms.user.pojo.UserDO;
import com.coco.naruto.arms.user.service.UserService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chuanzhang
 * @description 用户查询服务
 * @date 2021/6/21
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/detail")
    public UserDO queryUserDetail(@RequestParam Long userId) {
        return userService.queryUserDetail(userId);
    }

}
