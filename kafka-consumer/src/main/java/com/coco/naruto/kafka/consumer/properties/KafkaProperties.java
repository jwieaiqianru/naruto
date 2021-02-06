package com.coco.naruto.kafka.consumer.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author chuanzhang
 * @description kafka相关配置
 * @date 2021/2/5
 */
@Data
@Component
@ConfigurationProperties(prefix = "kafka.consumer")
public class KafkaProperties {
	private String bootstrapServers;
	private String topic;
}
