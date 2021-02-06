package com.coco.naruto.kafka.producer.interceptor;


import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.stereotype.Component;

/**
 * @author chuanzhang
 * @description  kafka 发送失败回调函数
 * @date 2021/2/6
 */
@Component
public class KafkaProducerCallback implements Callback {


	@Override
	public void onCompletion(RecordMetadata metadata, Exception exception) {
		if (exception != null) {
			exception.printStackTrace();
		}
	}
}
