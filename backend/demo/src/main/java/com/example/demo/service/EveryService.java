package com.example.demo.service;
import org.springframework.stereotype.Service;

import com.example.demo.model.entity.EveryEntity;
import com.example.demo.repository.EveryRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service 
public class EveryService {
      private final EveryRepository everyRepository;

      public EveryService(EveryRepository everyRepository) {
         this.everyRepository = everyRepository;
     }

   public Flux<EveryEntity> findAllNodes(){
      return everyRepository.findAllNodes();
     }

   public Mono<EveryEntity> findEdge(String name1, String name2) {
      return everyRepository.findEdge(name1, name2);
   }
    
   public Mono<EveryEntity> createEdge(String name1, String name2) {
      return everyRepository.createEdge(name1, name2);
  }
   public Mono<EveryEntity> deleteEdge(String name1, String name2) {
      return everyRepository.deleteEdge(name1, name2);
}
}

