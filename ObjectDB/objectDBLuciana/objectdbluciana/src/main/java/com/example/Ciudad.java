package com.example;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ciudad {

    @Id
    private int id;
    private String nombre;

    public Ciudad(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }
    
}
