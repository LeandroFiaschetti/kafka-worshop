package com.leandro.consumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

	private static final Log LOGGER = LogFactory.getLog(KafkaConsumer.class);

	@KafkaListener(topics = "#{'${kafka.consumer.topics}'.split(',')}")
	public void listenGroupFoo(
			@Payload String message,
			@Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition
	) {
		System.out.println(String.format("Received Message: %s from partition: %s ", message, partition));
	}

}
