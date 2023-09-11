package com.example.demo.repository;

import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.entity.TankEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TankRepository extends ReactiveNeo4jRepository<TankEntity, Long> {
    // A anotação @Query permite definir consultas usando a linguagem Cypher do Neo4j.
    @Query("MATCH (n: Tanque) RETURN n")// Retorna todos os nós Tanque.
    Flux<TankEntity> findAllTanks();

    @Query("CREATE (n: Tanque{name: $name, estado: $status, local: $location, condicao: $condition, sentido: $way}) RETURN n")// Cria nós Tanque.
    Mono<TankEntity> createTank(@Param("name") String name, @Param("status") String status, @Param("condition") String condition, @Param("location") String location,  @Param("way") String way);// Definindo os parâmetros para utilizar essa Query.

    @Query("MATCH (n:Tanque) WHERE id(n) = $id SET n.name = $name, n.estado = $status, n.local = $location, n.condicao = $condition, n.sentido = $way RETURN n")// Altera dados dos nós Tanque.
    Mono<TankEntity> updateTank(Long id, String name, String status, String location, String condition, String way);// Definindo os parâmetros para utilizar essa Query.

    @Query("MATCH (n:Tanque) WHERE id(n) = $id DELETE n")// Apaga nós Solenoide.
    Mono<TankEntity> deleteTank(Long id);// Definindo os parâmetros para utilizar essa Query.
}

