/*
 * Copyright (c) 2017 Author(s). All rights reserved.
 * 
 * @Author	- Anand Sivadas
 * @Date	- Jun 26, 2017
 * 
 * 
 */
package com.sivadas.anand.quickfeed.kafkapublisher.service;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * The Class KafkaPublisherService.
 */
@Component
public class KafkaPublisherService {
	
	/** The logger. */
	private static Logger LOGGER = LoggerFactory.getLogger(KafkaPublisherService.class);

	/** The quick feed topic. */
	@Value("${bootkafkaproducer.topic}")
	private  String quickFeedTopic;
	
	/** The bootstrap servers. */
	@Value("${bootkafkaproducer.bootstrap.servers}")
	private  String bootstrapServers;
	
	/** The acks. */
	@Value("${bootkafkaproducer.acks}")
	private  String acks;
	
	/** The retries. */
	@Value("${bootkafkaproducer.retries}")
	private  String retries;
	
	/** The batch size. */
	@Value("${bootkafkaproducer.batch.size}")
	private  String batchSize;
	
	/** The linger milli seconds. */
	@Value("${bootkafkaproducer.linger.ms}")
	private  String lingerMilliSeconds;
	
	/** The buffer memory. */
	@Value("${bootkafkaproducer.buffer.memory}")
	private  String bufferMemory;
	
	/** The serializer key. */
	@Value("${bootkafkaproducer.key.serializer}")
	private  String serializerKey;
	
	/** The serializer value. */
	@Value("${bootkafkaproducer.value.serializer}")
	private  String serializerValue;
	
	/**
	 * Push feeds.
	 */
	public void pushFeeds() {
	    Properties props = new Properties();
	    props.put("bootstrap.servers", bootstrapServers);
	    props.put("acks", acks);
	    props.put("retries", retries);
	    props.put("batch.size", batchSize);
	    props.put("linger.ms", 1);
	    props.put("buffer.memory", 33554432);
	    props.put("key.serializer", serializerKey);
	    props.put("value.serializer", serializerValue);
	    Producer<String, String> producer = null;
	    try {
	      producer = new KafkaProducer<>(props);
	      for (int i = 0; i < 10; i++) {
	        String msg = "{'menu':{'id':'file','value':'File','popup':{'menuitem':[{'value':'New','onclick':'CreateNewDoc()'},{'value':'Open','onclick':'OpenDoc()'},{'value':'Close','onclick':'CloseDoc()'}]}}} " + i;
	        producer.send(new ProducerRecord<String, String>(quickFeedTopic, msg));
	        LOGGER.info("Sent:" + msg);
	      }
	    } catch (Exception exception) {
	      LOGGER.error("exception while pushing feeds ", exception);
	    } finally {
	      producer.close();
	    }
	}
}
