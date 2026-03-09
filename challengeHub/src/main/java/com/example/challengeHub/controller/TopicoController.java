package com.example.challengeHub.controller;

import com.example.challengeHub.domain.topico.Topico;
import com.example.challengeHub.dto.DadosAtualizacaoTopico;
import com.example.challengeHub.dto.DadosCadastroTopico;
import com.example.challengeHub.repository.TopicoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")

public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroTopico dados){

        Optional<Topico> topicoExistente =
                repository.findByTituloAndMensagem(dados.titulo(), dados.mensagem());

        if(topicoExistente.isPresent()){
            throw new RuntimeException("Tópico duplicado");
        }

        Topico topico = new Topico();

        topico.setTitulo(dados.titulo());
        topico.setMensagem(dados.mensagem());
        topico.setAutor(dados.autor());
        topico.setCurso(dados.curso());
        topico.setDataCriacao(LocalDateTime.now());
        topico.setStatus("ABERTO");

        repository.save(topico);
    }

    @GetMapping
    public List<Topico> listar(){

        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Topico detalhar(@PathVariable Long id){

        return repository.getReferenceById(id);
    }

    @PutMapping("/{id}")
    @Transactional
    public void atualizar(@PathVariable Long id,
                          @RequestBody @Valid DadosAtualizacaoTopico dados){

        Topico topico = repository.getReferenceById(id);

        if(dados.titulo() != null){
            topico.setTitulo(dados.titulo());
        }

        if(dados.mensagem() != null){
            topico.setMensagem(dados.mensagem());
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){

        repository.deleteById(id);
    }
}