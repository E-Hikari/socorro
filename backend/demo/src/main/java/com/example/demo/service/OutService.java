package com.example.demo.service;
import org.springframework.stereotype.Service;

import com.example.demo.model.entity.OutEntity;
import com.example.demo.repository.OutRepository;

import reactor.core.publisher.Flux;

@Service 
public class OutService {
     private final OutRepository outRepository;
     public OutService(final OutRepository out_repository) {
        this.outRepository = out_repository;
     }

     public Flux<OutEntity> findAllOuts(){
        return outRepository.findAllOuts();
     }
}

