package com.example.challengeHub.controller;

import com.example.challengeHub.dto.DadosLogin;
import com.example.challengeHub.service.TokenService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")

public class AuthController {

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public String login(@RequestBody @Valid DadosLogin dados){

        return tokenService.gerarToken(dados.login());
    }
}