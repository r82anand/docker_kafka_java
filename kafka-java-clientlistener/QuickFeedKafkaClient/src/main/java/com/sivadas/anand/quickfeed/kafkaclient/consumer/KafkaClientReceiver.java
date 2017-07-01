/*
 * Copyright (c) 2017 Author(s). All rights reserved.
 * 
 * @Author	- Anand Sivadas
 * @Date	- Jul 1, 2017
 * 
 */
package com.sivadas.anand.quickfeed.kafkaclient.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * The Class KafkaClientReceiver.
 */
public class KafkaClientReceiver {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaClientReceiver.class);

	/**
	 * Listen to Kafka and consume the message.
	 *
	 * @param message the message
	 */
	@KafkaListener(topics = "${bootkafkaclient.topic}")
	public void listen(String message) {
		LOGGER.info("Received Messasge in group foo: " + message);
	}
}
