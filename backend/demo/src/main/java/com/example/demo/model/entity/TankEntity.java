package com.example.demo.model.entity;

import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

// A anotação @Node indica que essa classe representa um nó no banco de dados Neo4j.
@Node(labels = {"Tanque"})
public class TankEntity extends EveryEntity {

    //@Property é usada para mapear o campo 'status' como uma propriedade do nó.
    @Property(name = "estado")
    private String status;

    //@Property é usada para mapear o campo 'location' como uma propriedade do nó.
    @Property(name = "local")
    private String location;

    //@Property é usada para mapear o campo 'condition' como uma propriedade do nó.
    @Property(name = "condicao")
    private String condition;

    //@Property é usada para mapear o campo 'way' como uma propriedade do nó.
    @Property(name = "sentido")
    private String way;

    // Criando a classe TankEntity.
    public TankEntity(Long id, String name, String status, String location, String condition, String way) {
        // Chama a classe base TankEntity para inicializar o id, nome, estado, local, condição e sentido.
        this.id = id;
        this.name = name;
        this.status = status;
        this.location = location;
        this.condition = condition;
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

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }
}

