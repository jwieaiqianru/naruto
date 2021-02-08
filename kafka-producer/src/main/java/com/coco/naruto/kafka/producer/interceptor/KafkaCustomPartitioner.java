package com.coco.naruto.kafka.producer.interceptor;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;

/**
 * @author chuanzhang
 * @description  kafka 自定义分区
 * @date 2021/2/6
 */
public class KafkaCustomPartitioner  implements Partitioner {

	@Override
	public void configure(Map<String, ?> configs) {

	}


	@Override
	public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
		String keyString = key.toString();
		if (keyString.startsWith("message")) {
			return 1;
		}
		return 0;
	}

	@Override
	public void close() {

	}
}
