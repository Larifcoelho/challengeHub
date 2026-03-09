ChallengeHub
--

*Descrição*

O ChallengeHub foi um desafio feito para fixação de conteúdo do curso Oracle Next One com Alura, é uma aplicação backend construída com Spring Boot, que permite gerenciar usuários e desafios. Ela possui integração com MySQL, controle de acesso básico com Spring Security, e versionamento do banco de dados com Flyway.

----

*Tecnologias utilizadas*

Java 23

Spring Boot 3.5.11

Spring Data JPA

Spring Security

Flyway

MySQL 8

Maven

Lombok

----

*Endpoints principais*

Usuários

POST /users/register - Cadastra um novo usuário

GET /users - Lista todos os usuários (requer autenticação)

Desafios

POST /challenges - Cria um novo desafio

GET /challenges - Lista todos os desafios

-----

*Melhorias futuras*

Paginação de tópicos

Sistema de respostas

Documentação com Swagger

Testes automatizados

Deploy na nuvem
