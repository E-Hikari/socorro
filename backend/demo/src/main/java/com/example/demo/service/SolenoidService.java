package com.example.demo.service;
import org.springframework.stereotype.Service;

import com.example.demo.model.entity.SolenoidEntity;
import com.example.demo.repository.SolenoidRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service 
public class SolenoidService {
     private final SolenoidRepository solenoidRepository;
     
     public SolenoidService(final SolenoidRepository solenoid_repository) {
        this.solenoidRepository = solenoid_repository;
     }

     public Flux<SolenoidEntity> findAllSolenoids(){
        return solenoidRepository.findAllSolenoids();
     }

       public Mono<SolenoidEntity> createSolenoid(SolenoidEntity solenoid){
      return solenoidRepository.createSolenoid(
         solenoid.getName(),
         solenoid.getStatus(),
         solenoid.getLocation());
         
   }

   public Mono<SolenoidEntity> updateSolenoid(Long id, SolenoidEntity solenoid){
      return solenoidRepository.updateSolenoid(
         id,
         solenoid.getName(),
         solenoid.getStatus(),
         solenoid.getLocation());
     
   }

   public Mono<SolenoidEntity> deleteSolenoid(Long id){
      return solenoidRepository.deleteSolenoid(id);
   }
}
