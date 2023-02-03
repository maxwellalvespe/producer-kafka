package com.maxwell.producerkafka.conf;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.support.converter.KafkaMessageHeaders;

import java.util.HashMap;
import java.util.Objects;

@Configuration
@RequiredArgsConstructor
public class KafkaTopicConfig {

    private final KafkaProperties properties;

    @Bean
    public KafkaAdmin obtendoPropriedadesDoKafkaAdmin() {
        var conf = new HashMap<String, Object>();
        conf.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());
        return new KafkaAdmin(conf);
    }

    @Bean
    public KafkaAdmin.NewTopics criandoTopicos() {
        return new KafkaAdmin.NewTopics(
                TopicBuilder.name("max-topic")
                        .partitions(2)
                        .replicas(1)
                        .build()
        );
    }
}
