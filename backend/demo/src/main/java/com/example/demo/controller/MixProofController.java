package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.MixProofService;
import com.example.demo.model.entity.MixProofEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/mixproof")// Direcionando todas as requisições de MixProof para /mixproof
public class MixProofController {
    private final MixProofService mixProofService;

    // Adicionando a instância MixProofService no controller.
    public MixProofController(MixProofService mixproof_Service){
        this.mixProofService = mixproof_Service;
    }

    // Direciona as solicitações GET por este método.
    @GetMapping()
    public Flux<MixProofEntity> findAllMixProofs(){       
        return mixProofService.findAllMixProofs();// Retorna todos os nós MixProof
    }

    // Direciona as solicitações POST por este método.
    @PostMapping()
    public Mono<MixProofEntity> createMixProof(@RequestBody MixProofEntity mixproof){
        return mixProofService.createMixProof(mixproof);// Cria novos nós MixProof
    }

    // Direciona as solicitações de UPDATE por este método.
    @PutMapping("/{id}")
    public Mono<ResponseEntity<MixProofEntity>> updateMixProof(@PathVariable Long id, @RequestBody MixProofEntity mixproof){
        // Chama o método updateMixProof() do MixProofService para atualizar um nó Mixproof.
        Mono<MixProofEntity> updatedMixProof = mixProofService.updateMixProof(id, mixproof);

        // Mapeia o resultado, com OK se atualizado ou NOT_FOUND se não encontrado.
        return updatedMixProof.map(updated -> ResponseEntity.ok(updated))
            .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    // Direciona as solicitações DELETE por este método.
    @DeleteMapping("/{id}")
    public Mono<MixProofEntity> deleteMixProof(@PathVariable Long id){
        return mixProofService.deleteMixProof(id);// Apaga nós Mixproof
    }
}

