package com.coco.naruto.kafka.producer.controller;

import com.coco.naruto.kafka.producer.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chuanzhang
 * @description  用户controller
 * @date 2021/2/5
 */
@RestController
public class UserController {

	@Resource
	private UserService userService;

	@GetMapping("/send/message")
	public String testSendKafkaMsg(@RequestParam String prefix, @RequestParam Integer num) {
		userService.simpleSendMessage(prefix,num);
		return "ok";
	}

}
