/*
 * Copyright (c) 2017 Author(s). All rights reserved.
 * 
 * @Author	- Anand Sivadas
 * @Date	- Jul 1, 2017
 * 
 */
package com.sivadas.anand.quickfeed.kafkaclient.consumer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

import com.sivadas.anand.quickfeed.kafkaclient.domain.User;
import com.sivadas.anand.quickfeed.kafkaclient.domain.UserFeeds;

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
	public void listen(UserFeeds message) {
		LOGGER.info("Received Messasge in group foo: " + message);
		extractMessageFromRecord(message);
	}
	
	private void extractMessageFromRecord(UserFeeds userFeeds) {
		
		List<User> userList = userFeeds.getUserList();
		for (User user : userList) {
			LOGGER.info("User = " + user.toString());
		}
		
	}
}
