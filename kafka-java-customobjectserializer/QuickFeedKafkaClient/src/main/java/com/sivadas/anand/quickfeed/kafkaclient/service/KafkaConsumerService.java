/*
 * Copyright (c) 2017 Author(s). All rights reserved.
 * 
 * @Author	- Anand Sivadas
 * @Date	- Jun 26, 2017
 * 
 * 
 */
package com.sivadas.anand.quickfeed.kafkaclient.service;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sivadas.anand.quickfeed.kafkaclient.domain.User;
import com.sivadas.anand.quickfeed.kafkaclient.domain.UserFeeds;

/**
 * The Class KafkaConsumerService.
 */
@Component
public class KafkaConsumerService {
	
	/** The logger. */
	private static Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerService.class);

	/** The quick feed topic. */
	@Value("${bootkafkaclient.topic}")
	private  String quickFeedTopic;
	
	/** The bootstrap servers. */
	@Value("${bootkafkaclient.bootstrap.servers}")
	private  String bootstrapServers;
	
	/** The group id. */
	@Value("${bootkafkaclient.group.id}")
	private  String groupId;
	
	/** The enable auto commit. */
	@Value("${bootkafkaclient.enable.auto.commit}")
	private  String enableAutoCommit;
	
	/** The auto offset reset. */
	@Value("${bootkafkaclient.auto.offset.reset}")
	private  String autoOffsetReset;
	
	/** The deserializer key. */
	@Value("${bootkafkaclient.key.deserializer}")
	private  String deserializerKey;
	
	/** The deserializer value. */
	@Value("${bootkafkaclient.value.deserializer}")
	private  String deserializerValue;

	/**
	 * Gets the kafka messages.
	 *
	 * @return the kafka messages
	 */
	public void getKafkaMessages() {
	    Properties props = new Properties();
	    props.put("bootstrap.servers", bootstrapServers);
	    props.put("group.id", groupId);
	    props.put("enable.auto.commit", enableAutoCommit);
	    props.put("auto.commit.interval.ms", "1000");
	    props.put("auto.offset.reset", autoOffsetReset);
	    props.put("session.timeout.ms", "30000");
	    props.put("key.deserializer", deserializerKey);
	    props.put("value.deserializer", deserializerValue);

	    KafkaConsumer<String, UserFeeds> kafkaConsumer = new KafkaConsumer<>(props);
	    kafkaConsumer.subscribe(Arrays.asList(quickFeedTopic));
	    while (true) {
	      ConsumerRecords<String, UserFeeds> records = kafkaConsumer.poll(100);
	      for (ConsumerRecord<String, UserFeeds> record : records) {
	        LOGGER.info("Partition: " + record.partition() + " Offset: " + record.offset()
	            + " Value: " + record.value() + " ThreadID: " + Thread.currentThread().getId());
	        extractMessageFromRecord(record.value());
	      }
	    }
	}
	
	private void extractMessageFromRecord(UserFeeds userFeeds) {
		
		List<User> userList = userFeeds.getUserList();
		for (User user : userList) {
			LOGGER.info("User = " + user.toString());
		}
		
	}
	
}
