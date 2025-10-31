package com.example.demo;

public class Producto {
    
    private int id;
    private String nombre;

    public Producto(){

    }

    public Producto(String nombre){
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
