package LoayNaser;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.connect.runtime.Connect;

import java.sql.Connection;
import java.util.*;
import java.text.*;
import java.util.ArrayList;
import java.util.Properties;




public class KafkaListener {

    public KafkaConsumer<String, String> consumer = null;
    public String Topic;
    public String BrokerAddress;



    public KafkaListener(String TopicName,String BrokerAddress){
        this.Topic=TopicName;
        this.BrokerAddress=BrokerAddress;
        System.out.println( BrokerAddress );
        Properties prop = hintConsumer(BrokerAddress);
        this.consumer = new KafkaConsumer<>(prop);
        if(this.consumer == null )
            return;
        ArrayList<String> topics = new ArrayList<String>();
        topics.add(Topic);


        consumer.subscribe(topics);

        while (true){
            ConsumerRecords records = consumer.poll(1000);
            printRecords(records);
        }
    }


    private static void printRecords(ConsumerRecords<String, String> records)
    {
        ServerCon sc = new ServerCon( "192.168.61.135","loay","1234" );
        Connection myConnection = sc.Connect();
        for (ConsumerRecord<String, String> record : records) {
            System.out.println(String.format("Topic: %s, Partition: %d, Offset: %d, Key: %s, Value: %s", record.topic(), record.partition(), record.offset(), record.key(), record.value()));

             String recordValue;
             recordValue = record.value();
             //System.out.println("Current Date: " + ft.format(dNow));
             System.out.println( recordValue + " \n" );
             mysqlInsertProd.start(recordValue );


        }
    }


    private Properties hintConsumer(String Address) {
        if(Address.isEmpty())
            return null;
        Properties props = new Properties();
        props.put("bootstrap.servers", Address.toString() );
        props.put("group.id","mygroup");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("max.poll.records", 2147483647);
        props.put("max.partition.fetch.bytes", 10485760); //need this too
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        props.put("fetch.message.max.bytes", 10485760);

        return props;
    }


}
