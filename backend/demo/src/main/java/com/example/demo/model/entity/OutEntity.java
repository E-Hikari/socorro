package com.example.demo.model.entity;

import org.springframework.data.neo4j.core.schema.Node;

// A anotação @Node indica que essa classe representa um nó no banco de dados Neo4j.
@Node(labels = {"Saida"})
public class OutEntity extends EveryEntity {

    // Criando a classe OutEntity.
    public OutEntity(Long id, String name) {
        // Chama a classe base OutEntity para inicializar o id e nome.
        this.id = id;
        this.name = name;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

}

