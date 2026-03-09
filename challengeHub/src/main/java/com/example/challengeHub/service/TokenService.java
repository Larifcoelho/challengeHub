package com.example.challengeHub.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service

public class TokenService {

    private String secret = "123456";

    public String gerarToken(String login){

        return JWT.create()
                .withSubject(login)
                .withExpiresAt(new Date(System.currentTimeMillis() + 86400000))
                .sign(Algorithm.HMAC256(secret));
    }
}