package com.maxwell.producerkafka.resource;

import com.maxwell.producerkafka.model.Usuario;
import com.maxwell.producerkafka.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class User {

    private final UserService service;

    @PostMapping
    @SneakyThrows
    public ResponseEntity<?> post(@RequestBody Usuario usuario) {

        service.postUser(usuario);

        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }
}
