package com.maxwell.producerkafka.conf;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;


import java.io.Serializable;
import java.util.HashMap;

@Configuration
@RequiredArgsConstructor
public class JsonProducerConfig {

    private final KafkaProperties properties;

    @Bean
    public ProducerFactory jsonProducerFactory(){

        var confg = new HashMap<String,Object>();
        confg.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,properties.getBootstrapServers());
        confg.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
        confg.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,JsonSerializer.class);

        return new DefaultKafkaProducerFactory(confg,
                new StringSerializer(),
                new JsonSerializer());

    }


    @Bean
    public KafkaTemplate<String, Serializable> jsonTemplate(){
        return new KafkaTemplate<String,Serializable>(jsonProducerFactory());
    }
}
