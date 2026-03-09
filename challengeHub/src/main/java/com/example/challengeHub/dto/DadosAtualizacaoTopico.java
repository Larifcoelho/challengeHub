package com.example.challengeHub.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoTopico(

        @NotNull
        Long id,

        String titulo,

        String mensagem

) {
}