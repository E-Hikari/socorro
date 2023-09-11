package com.example.demo.model.entity;

import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

// A anotação @Node indica que essa classe representa um nó no banco de dados Neo4j.
@Node(labels = {"Solenoide"})
public class SolenoidEntity extends EveryEntity {

    // @Property é usada para mapear o campo 'status' como uma propriedade do nó.
    @Property(name = "estado")
    private String status;

    // @Property é usada para mapear o campo 'location' como uma propriedade do nó.
    @Property(name = "local")
    private String location;

    // Criando a classe SolenoidEntity.
    public SolenoidEntity(Long id, String name, String status, String location) {
        // Chama a classe base SolenoidEntity para inicializar o id, nome, estado e local.
        this.id = id;
        this.name = name;
        this.status = status;
        this.location = location;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

