package com.coco.naruto.kafka.consumer.config;

import cn.hutool.core.collection.CollUtil;
import com.coco.naruto.kafka.consumer.properties.KafkaProperties;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.annotation.Resource;
import java.util.Properties;

/**
 * @author chuanzhang
 * @description kafka consumer config
 * @date 2021/2/5
 */

@Configuration
@DependsOn(value = "kafkaProperties")
public class KafkaConsumerConfiguration {

	@Resource
	private KafkaProperties kafkaProperties;


	@Bean(name = "kafkaConsumer", destroyMethod = "close")
	public KafkaConsumer<String, String> buildKafkaConsumer() {
		Properties properties = new Properties();
		properties.setProperty(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
		properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "my-group-id");
		properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
		properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
		// 禁用自动提交
		properties.setProperty(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
		// 不允许自动创建topic
		properties.setProperty(ConsumerConfig.ALLOW_AUTO_CREATE_TOPICS_CONFIG, "false");
		properties.setProperty(ConsumerConfig.CLIENT_ID_CONFIG, "consumer-1");
		KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(properties);
		kafkaConsumer.subscribe(CollUtil.newArrayList(kafkaProperties.getTopic()));
		return kafkaConsumer;
	}

}
