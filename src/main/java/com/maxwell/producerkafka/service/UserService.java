package com.maxwell.producerkafka.service;

import com.maxwell.producerkafka.model.Usuario;

import java.util.concurrent.ExecutionException;

public interface UserService {

    void postUser(Usuario usuario) throws ExecutionException, InterruptedException;
}
