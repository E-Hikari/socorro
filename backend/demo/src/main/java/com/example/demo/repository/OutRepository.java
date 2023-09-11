package com.example.demo.repository;

import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import com.example.demo.model.entity.OutEntity;

import reactor.core.publisher.Flux;

public interface OutRepository extends ReactiveNeo4jRepository<OutEntity, Long>{
    // A anotação @Query permite definir consultas usando a linguagem Cypher do Neo4j.
     @Query("MATCH (n: Saida) RETURN n")// Retorna todos os nós de saída.
    Flux<OutEntity> findAllOuts();
}
