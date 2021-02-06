package com.coco.naruto.kafka.consumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.time.Duration;

/**
 * @author chuanzhang
 * @description 接受消息
 * @date 2021/2/5
 */
@Slf4j
@Component
public class Consumer {

	@Qualifier(value = "kafkaConsumer")
	@Resource
	private KafkaConsumer<String, String> kafkaConsumer;

	@PostConstruct
	public void init() {

		try {
			while (true) {
				ConsumerRecords<String, String> consumerRecords = kafkaConsumer.poll(Duration.ofMillis(500));
				for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
					log.info("receiving msg , partition:{}, topic:{} ,offset:{} ,key:{}, value:{}", consumerRecord.partition(),
							consumerRecord.topic(), consumerRecord.offset(), consumerRecord.key(), consumerRecord.value());
				}
				kafkaConsumer.commitSync();
			}
		} finally {
			kafkaConsumer.close();
		}
	}
}
