package com.cloudstudio.service.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class KafkaProducerApp {
	
	public static void main(String args[]) {
		
		
		String key="1";
		String message="kafka 2-------";
		
		  Properties props = new Properties();
	      
	      props.put("bootstrap.servers", "localhost:9092");
	      props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
	      props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
	      
	      
	      Producer<String, String> producer = new KafkaProducer<String, String>(props);
	      
	      ProducerRecord producerRecord  = new ProducerRecord<String, String>("springboottopic",key,message);
	      
	      producer.send(producerRecord);
	      
	      producer.close();
	      
	      
	      
	}

}
