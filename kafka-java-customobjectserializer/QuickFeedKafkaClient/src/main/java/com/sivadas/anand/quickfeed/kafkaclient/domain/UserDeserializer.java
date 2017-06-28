/*
 * Copyright (c) 2017 Author(s). All rights reserved.
 * 
 * @Author	- Anand Sivadas
 * @Date	- 28 Jun, 2017
 * 
 * 
 */
package com.sivadas.anand.quickfeed.kafkaclient.domain;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The Class UserDeserializer.
 */
public class UserDeserializer implements Deserializer<UserFeeds>{

	/** The logger. */
	private static Logger LOGGER = LoggerFactory.getLogger(UserDeserializer.class);
	
	/* (non-Javadoc)
	 * @see org.apache.kafka.common.serialization.Deserializer#configure(java.util.Map, boolean)
	 */
	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.apache.kafka.common.serialization.Deserializer#deserialize(java.lang.String, byte[])
	 */
	@Override
	public UserFeeds deserialize(String topic, byte[] data) {
	    
		ObjectMapper mapper = new ObjectMapper();
	    UserFeeds userFeed = null;
	    try {
	      userFeed = mapper.readValue(data, UserFeeds.class);

	    } catch (Exception exception) {
	    	LOGGER.error("error while deserializing the message ", exception);
	    }

	    return userFeed;
	}

	/* (non-Javadoc)
	 * @see org.apache.kafka.common.serialization.Deserializer#close()
	 */
	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

}
