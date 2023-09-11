package com.example.demo.repository;

import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.entity.MixProofEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface MixProofRepository extends ReactiveNeo4jRepository<MixProofEntity, Long>{
    // A anotação @Query permite definir consultas usando a linguagem Cypher do Neo4j.
    @Query("MATCH (n: MixProof) RETURN n")// Retorna todos os nós Mixproof.
    Flux<MixProofEntity> findAllMixProofs();

    @Query("CREATE (n: MixProof{name: $name, local: $location, sentido: $way}) RETURN n")// Cria nós Mixproof.
    Mono<MixProofEntity> createMixProof(@Param("name") String name, @Param("location") String location, @Param("way") String way);// Definindo os parâmetros para utilizar essa Query.

    @Query("MATCH (n:MixProof) WHERE id(n) = $id SET n.name = $name, n.local = $location, n.sentido = $way RETURN n")// Altera dados dos nós Mixproof.
    Mono<MixProofEntity> updateMixProof(Long id, String name, String location, String way);// Definindo os parâmetros para utilizar essa Query.

    @Query("MATCH (n: MixProof) WHERE id(n) = $id DELETE n")// Apaga nós Mixproof.
    Mono<MixProofEntity> deleteMixProof(Long id);// Definindo os parâmetros para utilizar essa Query.
}
