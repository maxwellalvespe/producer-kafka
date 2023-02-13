package com.maxwell.producerkafka.service.impl;

import com.maxwell.producerkafka.conf.StringProducerFactoryConfig;
import com.maxwell.producerkafka.model.Usuario;
import com.maxwell.producerkafka.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    //TODO nesse exemplo o value está como serializable pois preciso produzir um JSON to tipo usuario, e ao deixar o value como Object o retorno do template é null.
    private final KafkaTemplate<String, Serializable> template;

    @Override
    public void postUser(Usuario usuario) throws ExecutionException, InterruptedException {
        template.send("max-topic", usuario);

        log.info("User registrado no topico :::  {}", usuario);
    }
}
