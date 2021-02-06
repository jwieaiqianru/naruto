package com.coco.naruto.kafka.producer.service;

import cn.hutool.core.util.RandomUtil;
import com.coco.naruto.kafka.producer.interceptor.KafkaProducerCallback;
import com.coco.naruto.kafka.producer.properties.KafkaProperties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author chuanzhang
 * @description user service
 * @date 2021/2/5
 */
@Service
public class UserService {

	@Qualifier(value = "kafkaProducer")
	@Resource
	private KafkaProducer<String, String> kafkaProducer;
	@Resource
	private KafkaProperties kafkaProperties;
	@Resource
	private KafkaProducerCallback kafkaProducerCallback;

	public void simpleSendMessage(String prefix, Integer num) {

		for (int i = 0; i < num; i++) {
			String key = RandomUtil.randomString(6);
			ProducerRecord<String, String> producerRecord = new ProducerRecord<>(kafkaProperties.getTopic(), prefix + "-" + key, RandomUtil.randomString(10));
			kafkaProducer.send(producerRecord, kafkaProducerCallback);
		}
	}

}
