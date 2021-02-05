package com.coco.naruto.kafka.producer.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author chuanzhang
 * @description TODO
 * @date 2021/2/5
 */
@Data
@Component
@ConfigurationProperties(prefix = "kafka.producer")
public class KafkaProperties {

	private String bootstrapServers;

}
