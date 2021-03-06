package com.cloudstudio.service.consumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class KafkaConsumerApp {
	
	public static void main(String args[]) {
		
		String topicName = "springboottopic";
        String groupName = "group_id";
		
		  Properties props = new Properties();
	      
		  props.put("bootstrap.servers", "localhost:9092");
	     props.put("group.id", groupName);
	     // props.put("enable.auto.commit", "true");
	     // props.put("auto.commit.interval.ms", "1000");
	      //props.put("session.timeout.ms", "30000");
	      props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	      props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	      
	      KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
	      
	      consumer.subscribe(Arrays.asList(topicName));
	      Duration minutes = Duration.ofMinutes(10);
	      
	      while (true){
              ConsumerRecords<String, String> records = consumer.poll(minutes);
              for (ConsumerRecord<String, String> record : records){
            	  System.out.println("receiving messge in consumer 1   "+record.value());
              }
         }
	      
	      
	      
	}

}
