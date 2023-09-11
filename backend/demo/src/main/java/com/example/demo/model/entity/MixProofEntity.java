package com.example.demo.model.entity;

import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

// A anotação @Node indica que essa classe representa um nó no banco de dados Neo4j.
@Node(labels = {"MixProof"})
public class MixProofEntity extends EveryEntity {
    // @Property é usada para mapear o campo 'location' como uma propriedade do nó.
    @Property(name = "local")
    private String location;

    // @Property é usada para mapear o campo 'way' como uma propriedade do nó.
    @Property(name = "sentido")
    private String way;

    // Criando a classe MixProofEntity.
    public MixProofEntity(Long id, String name, String location, String way) {
        // Chama a classe base MixProofEntity para inicializar o id, nome, local e direção.
        this.id = id;
        this.name = name;
        this.location = location;
        this.way = way;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }
}

