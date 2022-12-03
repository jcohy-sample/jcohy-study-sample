package com.jcohy.sample.kafka;

import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class CustomProducer {

	public static void main(String[] args) {

		Properties properties = new Properties();

		properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.11.234:9092,192.168.11.234:9093,192.168.11.234:9094");

		properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());

		KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(properties);

		kafkaProducer.send(new ProducerRecord<>("first", "Hello World!"), (metadata, exception) -> {
			if (exception != null) {
				System.err.println("发送数据到kafka中,发生了异常.");
				exception.printStackTrace();
			} else {
				System.out.println("主题：" + metadata.topic() + " 分区：" + metadata.partition());
			}


		});

		kafkaProducer.close();
	}
}
