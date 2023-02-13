package com.maxwell.producerkafka.service;

import jakarta.websocket.SendResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProducerService {


    private  KafkaTemplate<String,String> template;


    public void produzirMenssagem(String value) throws ExecutionException, InterruptedException {

        log.info("producer message..");
        var stringStringSendResult = template.send("max-topic",value).get();
        log.info("result ::{}",stringStringSendResult);
        log.info("finally message..");
        log.info("possibilidades: ex=0  pode ocorrer perda de menssagem pois não temos o retorno ex; 200 ou 400");
        log.info("possibilidades: ex=1  msg enviado para o broker [lider], caso a primeira tentativa falhe e desse para a segunda partição e isso pode gerar duplicidade");
        log.info("possibilidade:  ex=all o envento e enviado para o broker, aguarda o retorno das replicas e após temos o retorno que a msg foi gravada");

        //callback é uma função utilizada para tratamento de erro "Dabloushoot"
    }
}
