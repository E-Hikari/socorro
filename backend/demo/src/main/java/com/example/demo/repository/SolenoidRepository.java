package com.example.demo.repository;

import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.entity.SolenoidEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SolenoidRepository extends ReactiveNeo4jRepository<SolenoidEntity, Long>{
    // A anotação @Query permite definir consultas usando a linguagem Cypher do Neo4j.
    @Query("MATCH (n: Solenoide) RETURN n")// Retorna todos os nós Solenoide.
    Flux<SolenoidEntity> findAllSolenoids();

    @Query("CREATE (n: Solenoide{name: $name, estado: $status, local: $location}) RETURN n")// Cria nós Solenoide.
    Mono<SolenoidEntity> createSolenoid(@Param("name") String name, @Param("status") String status, @Param("location") String location);// Definindo os parâmetros para utilizar essa Query.

    @Query("MATCH (n:Solenoide) WHERE id(n) = $id SET n.name = $name, n.estado = $status, n.local = $location RETURN n")// Altera dados dos nós Solenoide.
    Mono<SolenoidEntity> updateSolenoid(Long id, String name, String status, String location);// Definindo os parâmetros para utilizar essa Query.

    @Query("MATCH (n:Solenoide) WHERE id(n) = $id DELETE n")// Apaga nós Solenoide.
    Mono<SolenoidEntity> deleteSolenoid(Long id);// Definindo os parâmetros para utilizar essa Query.
}
