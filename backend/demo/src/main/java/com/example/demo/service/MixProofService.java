package com.example.demo.service;
import org.springframework.stereotype.Service;

import com.example.demo.model.entity.MixProofEntity;
import com.example.demo.repository.MixProofRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service 
public class MixProofService {
     private final MixProofRepository mixproofRepository;
     public MixProofService(final MixProofRepository mixproof_repository) {
        this.mixproofRepository = mixproof_repository;
     }

     public Flux<MixProofEntity> findAllMixProofs(){
        return mixproofRepository.findAllMixProofs();
     }

     
       public Mono<MixProofEntity> createMixProof(MixProofEntity mixproof){
      return mixproofRepository.createMixProof(
         mixproof.getName(),
         mixproof.getLocation(),
         mixproof.getWay());

         
   }

   public Mono<MixProofEntity> updateMixProof(Long id, MixProofEntity mixproof){
      return mixproofRepository.updateMixProof(
         id,
         mixproof.getName(),
         mixproof.getLocation(),
         mixproof.getWay()
         );
     
   }

   public Mono<MixProofEntity> deleteMixProof(Long id){
      return mixproofRepository.deleteMixProof(id);
   }
}

