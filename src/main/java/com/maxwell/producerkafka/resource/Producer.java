package com.maxwell.producerkafka.resource;


import com.maxwell.producerkafka.service.ProducerService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("message")
@RequiredArgsConstructor
public class Producer {

    private final ProducerService service;

    @PostMapping
    public String publish(@RequestBody String messagem) throws ExecutionException, InterruptedException {
        service.produzirMenssagem(messagem);
        return messagem;
    }
}
