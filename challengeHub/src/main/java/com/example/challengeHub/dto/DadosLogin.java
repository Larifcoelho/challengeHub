package com.example.challengeHub.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosLogin(

        @NotBlank
        String login,

        @NotBlank
        String senha

) {
}