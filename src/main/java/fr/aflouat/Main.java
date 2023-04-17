package fr.aflouat;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;


public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        System.out.println("Hello world!");
        log.info("Hello Log info from Logger");

        String bootstrapServers = "kafka-server1:9092";

        // create Producer properties
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        // create the producer
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        // create a producer record
        ProducerRecord<String, String> producerRecord =
                new ProducerRecord<>("test_topic", "hello world from app");

        // create a second producer record
        ProducerRecord<String, String> producerRecord2 =
                new ProducerRecord<>("test_topic", "another message ");


        // send data - asynchronous
        producer.send(producerRecord);
        producer.send(producerRecord2);


        // flush data - synchronous
        producer.flush();

        // flush and close producer
        producer.close();
    }
}