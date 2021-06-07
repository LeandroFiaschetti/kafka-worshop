/*
 * Copyright 2017-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.leandro;

import com.leandro.kafka.KafkaUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController(value = "ps")
public class WebController {

	private final KafkaUtils kafkaUtils;

	public WebController(KafkaUtils kafkaUtils) {
		this.kafkaUtils = kafkaUtils;
	}

	@GetMapping("/postKafkaMessage")
	public RedirectView publish(
			@RequestParam("topic") String topicName,
			@RequestParam("message") String message,
			@RequestParam("count") int messageCount,
			@RequestParam("partition") int partition
	) {
		this.kafkaUtils.sendKafkaMessage(messageCount, topicName, message, partition);
		return buildStatusView(messageCount + " Message enviado");
	}

	private RedirectView buildStatusView(String statusMessage) {
		RedirectView view = new RedirectView("/");
		view.addStaticAttribute("statusMessage", statusMessage);
		return view;
	}
}
