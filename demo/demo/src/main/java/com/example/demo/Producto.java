package com.example.demo;

public class Producto {
    
    private int id;
    private String nombre;
    private double precio;

    public Producto(){

    }

    public Producto(String nombre, double precio){
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio(){
        return precio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio){
        this.precio = precio;
    }

    
}
