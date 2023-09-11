package com.example.demo.service;
import org.springframework.stereotype.Service;

import com.example.demo.model.entity.EntryEntity;
import com.example.demo.repository.EntryRepository;

import reactor.core.publisher.Flux;

@Service 
public class EntryService {
     private final EntryRepository entryRepository;
     public EntryService(final EntryRepository entry_repository) {
        this.entryRepository = entry_repository;
     }

     public Flux<EntryEntity> findAllEntries(){
        return entryRepository.findAllEntries();
     }
}

