package com.example;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Departamento {
    @Id
    private int id;
    private String nombre;

    public Departamento() {
    }
    
    public Departamento(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    } 
}