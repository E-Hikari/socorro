package com.example.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.EveryService;
import com.example.demo.model.entity.EveryEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")// Direcionando requisições de nós e arestas para /api
public class EveryController {
    private final EveryService everyService;

    // Adicionando a instância EveryService no controller.
    public EveryController(EveryService every_Service){
        this.everyService = every_Service;
    }

    // Direciona as solicitações GET para "/every" por este método.
    @GetMapping("/every")
    public Flux<EveryEntity> findAllNodes(){       
        return everyService.findAllNodes();// Retorna todos os nós
    }

    // Direciona as solicitações GET para "/findEdge" por este método.
    @GetMapping("/edge/{name1}/{name2}")
    public Mono<EveryEntity> findEdge(@PathVariable String name1, @PathVariable String name2) {
        return everyService.findEdge(name1, name2);
    }
    
    // Direciona as solicitações POST por este método.
    @GetMapping("/createEdge/{name1}/{name2}")
    public Mono<EveryEntity> createEdge(@PathVariable String name1, @PathVariable String name2) {
        return everyService.createEdge(name1, name2);
    }
    
    // Direciona as solicitações DELETE por este método.
    @GetMapping("/deleteEdge/{name1}/{name2}")
    public Mono<EveryEntity> deleteEdge(@PathVariable String name1, @PathVariable String name2) {
        return everyService.deleteEdge(name1, name2);
    }
}

