package com.coco.naruto.arms.user.dubbo;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.RandomUtil;
import com.coco.naruto.api.arms.user.api.UserServiceApi;
import com.coco.naruto.api.arms.user.dto.UserDTO;
import com.coco.naruto.arms.user.pojo.UserDO;
import com.coco.naruto.arms.user.service.UserService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

/**
 * @author chuanzhang
 * @description TODO
 * @date 2021/6/21
 */
@Slf4j
@Service
@DubboService(version = "1.0.0")
public class UserServiceApiImpl implements UserServiceApi {


    private final static ExecutorService executorService = Executors.newFixedThreadPool(3);


    @Resource
    UserService userService;

    @Override
    public UserDTO queryUserDetail(Long userId) {

        executorService.execute(() -> {
            try {
                Thread.sleep(RandomUtil.randomInt(1,100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("线程池执行任务中");
        });
        UserDO userDO = userService.queryUserDetail(userId);
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(userDO.getUserName());
        userDTO.setId(userDO.getId());

        return userDTO;
    }
}
