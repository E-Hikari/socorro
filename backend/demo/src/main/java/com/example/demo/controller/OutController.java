package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.OutService;
import com.example.demo.model.entity.OutEntity;
import reactor.core.publisher.Flux;

@RestController
public class OutController {
    private final OutService outService;

    // Adicionando a instância OutService no controller.
    public OutController(OutService out_Service){
        this.outService = out_Service;
    }

    // Direciona as solicitações GET para "/out" por este método.
    @GetMapping("/out")
    public Flux<OutEntity> findAllOuts(){       
        return outService.findAllOuts();// Retorna todos os nós de saída
    }
}

