package com;
public class Cliente {

    private int id;
    private String nombre;
    private double telefono;

    public Cliente(){

    }

    public Cliente(String n, double t){
        this.nombre = n;
        this.telefono = t;

    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getTelefono() {
        return telefono;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(double telefono) {
        this.telefono = telefono;
    }

    
}
