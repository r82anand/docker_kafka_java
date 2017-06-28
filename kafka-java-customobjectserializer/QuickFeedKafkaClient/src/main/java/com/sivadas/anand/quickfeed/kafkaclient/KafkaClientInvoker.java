/*
 * Copyright (c) 2017 Author(s). All rights reserved.
 * 
 * @Author	- Anand Sivadas
 * @Date	- Jun 26, 2017
 * 
 * 
 */
package com.sivadas.anand.quickfeed.kafkaclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.sivadas.anand.quickfeed.kafkaclient.service.KafkaConsumerService;

/**
 * The Class KafkaClientInvoker.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class KafkaClientInvoker implements CommandLineRunner {

	/** The logger. */
	private static Logger LOGGER = LoggerFactory.getLogger(KafkaClientInvoker.class);

	/** The kafka consumer service. */
	@Autowired
	private KafkaConsumerService kafkaConsumerService;

	/* (non-Javadoc)
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	@Override
	public void run(String... args) {
		LOGGER.info("Starting kafkaConsumerService...");
		this.kafkaConsumerService.getKafkaMessages();
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws Exception the exception
	 */
	public static void main(String[] args) throws Exception {
		SpringApplication.run(KafkaClientInvoker.class, args);
	}
}
