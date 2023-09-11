package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.EntryService;
import com.example.demo.model.entity.EntryEntity;
import reactor.core.publisher.Flux;

@RestController
public class EntryController {
    private final EntryService entryService;

    // Adicionando a instância EntryService no controller.
    public EntryController(EntryService entry_Service){
        this.entryService = entry_Service;
    }

    // Direciona as solicitações GET para "/entry" por este método.
    @GetMapping("/entry")
    public Flux<EntryEntity> findAllEntries(){       
        return entryService.findAllEntries(); // Retorna todos os nós de entradas
    }
}

