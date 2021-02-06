package com.coco.naruto.kafka.producer.config;

import com.coco.naruto.kafka.producer.properties.KafkaProperties;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author chuanzhang
 * @description kafka 生产者配置类
 * @date 2021/2/5
 */
@Configuration
@DependsOn(value = "kafkaProperties")
public class KafkaProducerConfiguration {

	@Resource
	private KafkaProperties kafkaProperties;


	@Bean(name = "kafkaProducer")
	public KafkaProducer<String, String> buildKafkaProducer() {
		Properties properties = new Properties();
		properties.setProperty(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
		properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
		properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
		properties.setProperty(ProducerConfig.ACKS_CONFIG, "1");
		// 添加拦截器
		List<String> interceptors = new ArrayList<>();
		interceptors.add("com.coco.naruto.kafka.producer.interceptor.KafkaInterceptor");
		properties.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, interceptors);
		// 添加自定义分区器
		properties.setProperty(ProducerConfig.PARTITIONER_CLASS_CONFIG, "com.coco.naruto.kafka.producer.interceptor.KafkaCustomPartitioner");
		return new KafkaProducer<>(properties);
	}

}
