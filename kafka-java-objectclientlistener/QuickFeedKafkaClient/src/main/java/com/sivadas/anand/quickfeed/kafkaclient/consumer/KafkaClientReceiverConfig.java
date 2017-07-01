/*
 * Copyright (c) 2017 Author(s). All rights reserved.
 * 
 * @Author	- Anand Sivadas
 * @Date	- Jul 1, 2017
 * 
 */
package com.sivadas.anand.quickfeed.kafkaclient.consumer;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import com.sivadas.anand.quickfeed.kafkaclient.domain.UserDeserializer;
import com.sivadas.anand.quickfeed.kafkaclient.domain.UserFeeds;

/**
 * The Class KafkaClientReceiverConfig.
 */
@Configuration
@EnableKafka
public class KafkaClientReceiverConfig {

	/** The quick feed topic. */
	@Value("${bootkafkaclient.topic}")
	private String quickFeedTopic;

	/** The bootstrap servers. */
	@Value("${bootkafkaclient.bootstrap.servers}")
	private String bootstrapServers;

	/** The group id. */
	@Value("${bootkafkaclient.group.id}")
	private String groupId;

	/** The enable auto commit. */
	@Value("${bootkafkaclient.enable.auto.commit}")
	private String enableAutoCommit;

	/** The auto offset reset. */
	@Value("${bootkafkaclient.auto.offset.reset}")
	private String autoOffsetReset;

	/** The deserializer key. */
	@Value("${bootkafkaclient.key.deserializer}")
	private String deserializerKey;

	/** The deserializer value. */
	@Value("${bootkafkaclient.value.deserializer}")
	private String deserializerValue;

	/**
	 * Consumer configs.
	 *
	 * @return the map
	 */
	@Bean
	public Map<String, Object> consumerConfigs() {
		Map<String, Object> props = new HashMap<>();

		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, enableAutoCommit);
		props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffsetReset);
		props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, deserializerKey);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, deserializerValue);

		return props;
	}

	/**
	 * Consumer factory.
	 *
	 * @return the consumer factory
	 */
	@Bean
	public ConsumerFactory<String, UserFeeds> consumerFactory() {
		return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(), new UserDeserializer());
	}

	/**
	 * Kafka listener container factory.
	 *
	 * @return the concurrent kafka listener container factory
	 */
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, UserFeeds> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, UserFeeds> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());

		return factory;
	}

	/**
	 * Receiver.
	 *
	 * @return the kafka client receiver
	 */
	@Bean
	public KafkaClientReceiver receiver() {
		return new KafkaClientReceiver();
	}
}
