package com.example.demo.model.entity;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

// A anotação @Node indica que essa classe representa um nó no banco de dados Neo4j.
@Node
public class EveryEntity {
    @Id
    @GeneratedValue
    protected Long id;

    protected String name;

    // Criando a classe EveryEntity.
    public EveryEntity() {
       
    }
}
