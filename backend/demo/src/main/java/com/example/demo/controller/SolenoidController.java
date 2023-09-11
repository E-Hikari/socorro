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

import com.example.demo.service.SolenoidService;
import com.example.demo.model.entity.SolenoidEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/solenoid")// Direcionando todas as requisições de Solenoide para /solenoid
public class SolenoidController {
    private final SolenoidService solenoidService;

    // Adicionando a instância SolenoidService no controller.
    public SolenoidController(SolenoidService solenoidService){
        this.solenoidService = solenoidService;
    }

    // Direciona as solicitações GET por este método.
    @GetMapping()
    public Flux<SolenoidEntity> findAllSolenoids(){       
        return solenoidService.findAllSolenoids();// Retorna todos os nós Solenoide
    }
    
    // Direciona as solicitações POST por este método.
    @PostMapping()
    public Mono<SolenoidEntity> createSolenoid(@RequestBody SolenoidEntity solenoid){
        return solenoidService.createSolenoid(solenoid);// Cria novos nós Solenoide
    }

    // Direciona as solicitações UPDATE por este método.
    @PutMapping("/{id}")
    public Mono<ResponseEntity<SolenoidEntity>> updateSolenoid(@PathVariable Long id, @RequestBody SolenoidEntity solenoid){
        // Chama o método updateSolenoid() do SolenoidService para atualizar um nó solenoide.
        Mono<SolenoidEntity> updatedSolenoid = solenoidService.updateSolenoid(id, solenoid);

        // Mapeia o resultado, com OK se atualizado ou NOT_FOUND se não encontrado.
        return updatedSolenoid.map(updated -> ResponseEntity.ok(updated))
            .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    // Direciona as solicitações DELETE por este método.
    @DeleteMapping("/{id}")
    public Mono<SolenoidEntity> deleteSolenoid(@PathVariable Long id){
        return solenoidService.deleteSolenoid(id);// Deleta nós Solenoide
    }
}

