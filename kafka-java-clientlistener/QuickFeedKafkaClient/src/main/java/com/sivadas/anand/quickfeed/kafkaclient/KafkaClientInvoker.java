/*
 * Copyright (c) 2017 Author(s). All rights reserved.
 * 
 * @Author	- Anand Sivadas
 * @Date	- Jun 26, 2017
 * 
 */
package com.sivadas.anand.quickfeed.kafkaclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.sivadas.anand.quickfeed.kafkaclient.consumer.KafkaClientReceiver;

/**
 * The Class KafkaClientInvoker.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class KafkaClientInvoker {

	@Autowired
	KafkaClientReceiver kafkaReceiver;
	
	/** The logger. */
	private static Logger LOGGER = LoggerFactory.getLogger(KafkaClientInvoker.class);

	public static void main(String[] args) {
		LOGGER.info("Started the Kafka Client...");
	    SpringApplication.run(KafkaClientInvoker.class, args);
	  }
}
