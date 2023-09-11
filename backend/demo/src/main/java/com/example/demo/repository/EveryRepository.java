package com.example.demo.repository;

import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.entity.EveryEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface EveryRepository extends ReactiveNeo4jRepository<EveryEntity, Long>{
    // A anotação @Query permite definir consultas usando a linguagem Cypher do Neo4j.
    @Query("MATCH (n) RETURN n")//Retorna todos os nós.
    Flux<EveryEntity> findAllNodes();

    @Query("MATCH (n1)-[r:ROTA]->(n2) WHERE n1.name = $name1 AND n2.name = $name2 RETURN n1, r, n2")// Retorna o relacionamento entre nós.
    Mono<EveryEntity> findEdge(@Param("name1") String name1, @Param("name2") String name2);// Definindo os parâmetros para utilizar essa Query.

    @Query("MERGE (n1 {name:$name1})" + "MERGE (n2 {name:$name2})" + "CREATE (n1)-[:ROTA]->(n2)")// Cria um relacionamento entre nós.
    Mono<EveryEntity> createEdge(@Param("name1") String name1, @Param("name2") String name2);// Definindo os parâmetros para utilizar essa Query.

    @Query("MATCH (n1)-[r:ROTA]->(n2) WHERE n1.nome = $name1 AND n2.nome = $name2 DELETE r")// Deleta um relacionamento entre nós.
    Mono<EveryEntity> deleteEdge(@Param("name1") String name1, @Param("name2") String name2);// Definindo os parâmetros para utilizar essa Query.


}