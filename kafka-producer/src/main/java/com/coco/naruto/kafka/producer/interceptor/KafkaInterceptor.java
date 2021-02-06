package com.coco.naruto.kafka.producer.interceptor;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

/**
 * @author chuanzhang
 * @description TODO
 * @date 2021/2/6
 */
public class KafkaInterceptor implements ProducerInterceptor<String,String> {

	@Override
	public ProducerRecord<String,String> onSend(ProducerRecord record) {
		return new ProducerRecord<>(record.topic(),
				record.partition(), record.timestamp(), record.key().toString(), "interceptor-" + record.value().toString(), record.headers());
	}

	@Override
	public void onAcknowledgement(RecordMetadata metadata, Exception exception) {

	}

	@Override
	public void close() {

	}

	@Override
	public void configure(Map<String, ?> configs) {
		// do noting
	}
}
