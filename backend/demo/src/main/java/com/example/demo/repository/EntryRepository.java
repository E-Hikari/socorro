package com.example.demo.repository;

import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import com.example.demo.model.entity.EntryEntity;

import reactor.core.publisher.Flux;

public interface EntryRepository extends ReactiveNeo4jRepository<EntryEntity, Long> {

    // A anotação @Query permite definir consultas usando a linguagem Cypher do Neo4j.
    @Query("MATCH (n: Entrada) RETURN n")// Retorna todos os nós de entrada.
    Flux<EntryEntity> findAllEntries();
}

