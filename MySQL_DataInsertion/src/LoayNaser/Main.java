package LoayNaser;


import kafka.Kafka;

public class Main {

    public static void main(String[] args) {


        String KBA = GetConfig.getConfig( "brokersAddr" );
        KafkaListener kl = new KafkaListener("servertalk",KBA);

    }
}