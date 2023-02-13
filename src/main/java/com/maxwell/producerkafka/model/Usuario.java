package com.maxwell.producerkafka.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Usuario implements Serializable {

    private String id;
    private String nome;
    private int idade;
}
