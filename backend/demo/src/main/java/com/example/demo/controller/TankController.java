package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.TankService;
import com.example.demo.model.entity.TankEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/tank")// Direcionando todas as requisições de Tanque para /tank
public class TankController {
    private final TankService tankService;

    // Adicionando a instância TankService no controller.
    public TankController(TankService tankService){
        this.tankService = tankService;
    }

    // Direciona as solicitações GET por este método.
    @GetMapping()
    public Flux<TankEntity> findAllTanks(){       
        return tankService.findAllTanks();// Retorna todos os nós Tanque
    }

    // Direciona as solicitações POST por este método.
    @PostMapping()
    public Mono<TankEntity> createTank(@RequestBody TankEntity tank){
        return tankService.createTank(tank);// Cria novos nós Tanque
    }

    // Direciona as solicitações UPDATE por este método.
    @PutMapping("/{id}")
    public Mono<ResponseEntity<TankEntity>> updateTank(@PathVariable Long id, @RequestBody TankEntity tank){
        // Chama o método updateTank() do TankService para atualizar um nó tanque.
        Mono<TankEntity> updatedTank = tankService.updateTank(id, tank);

        // Mapeia o resultado, com OK se atualizado ou NOT_FOUND se não encontrado.
        return updatedTank.map(updated -> ResponseEntity.ok(updated))
            .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    // Direciona as solicitações DELETE por este método.
    @DeleteMapping("/{id}")
    public Mono<TankEntity> deleteTank(@PathVariable Long id){
        return tankService.deleteTank(id);// Deleta nós Tanque
    }
}
