package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.entity.TankEntity;
import com.example.demo.repository.TankRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service 
public class TankService {

   @Autowired
   private final TankRepository tankRepository;

   public TankService(final TankRepository tank_repository) {
      this.tankRepository = tank_repository;
   }

   public Flux<TankEntity> findAllTanks(){
      return tankRepository.findAllTanks();
   }

   public Mono<TankEntity> createTank(TankEntity tank){
      return tankRepository.createTank(
         tank.getName(),
         tank.getStatus(),
         tank.getCondition(),
         tank.getLocation(),
         tank.getWay());
   }

   public Mono<TankEntity> updateTank(Long id, TankEntity tank){
      return tankRepository.updateTank(
         id,
         tank.getName(),
         tank.getStatus(),
         tank.getLocation(),
         tank.getCondition(),
         tank.getWay());
   }

   public Mono<TankEntity> deleteTank(Long id){
      return tankRepository.deleteTank(id);
   }

}

