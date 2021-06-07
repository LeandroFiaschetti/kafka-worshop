package com.leandro.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.UUID;

@Component
public class KafkaUtils {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendKafkaMessage(long count, String topicName, String data, Integer partition) {
		for (int i = 0; i < count; i++) {
			Message<String> message = MessageBuilder
					.withPayload(data + i)
					.setHeader(KafkaHeaders.TOPIC, topicName)
					.setHeader(KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString())
					.setHeader(KafkaHeaders.PARTITION_ID, partition > 0 ? partition : null)
					.build();

			ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(message);

			future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
				@Override
				public void onSuccess(SendResult<String, String> result) {
					// hacer algo
				}

				@Override
				public void onFailure(Throwable ex) {
					System.out.println("Unable to send message=[" + message + "] due to : " + ex.getMessage());
				}
			});
		}
	}

}
