package com.maxwell.producerkafka.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProducerService {


    private final KafkaTemplate<String,String> template;


    public void produzirMenssagem(String value){

        log.info("producer message..");
        template.send("max-topic",value);
        log.info("finally message..");
    }
}
