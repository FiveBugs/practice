package kafka.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Arrays;
import java.util.Properties;

public class ReceiveInfoService implements Runnable{
    KafkaConsumer<String, String> consumer;
    String topic = "test";
    public ReceiveInfoService() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092,slave1:9092,slave2:9092");
        props.put("group.id", "1123");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("max.poll.records", 1000);
        props.put("auto.offset.reset", "earliest");
        props.put("key.deserializer", StringDeserializer.class.getName());
        props.put("value.deserializer", StringDeserializer.class.getName());
        consumer = new KafkaConsumer<String, String>(props);
        consumer.subscribe(Arrays.asList(topic));
    }

    @Override
    public void run() {
        System.out.println("consumer start");
        int msgNum = 1;
        ConsumerRecords<String, String> msgList;
        while(true) {
            msgList = consumer.poll(1000);
            if (msgList == null || msgList.isEmpty()) {
                continue;
            }

            for (ConsumerRecord<String, String> records : msgList) {
                if (msgNum % 100 == 0) {
                    System.out.println("consumer num:" + msgNum);
                }

                msgNum++;
            }

        }
    }
}
