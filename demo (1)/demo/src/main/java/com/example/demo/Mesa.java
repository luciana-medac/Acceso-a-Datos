package com.example.demo;
public class Mesa {

    private int id;
    private int numMesa;
    private Restaurante idRestaurante;

    public Mesa(){

    }

    public Mesa(int nM, Restaurante idRes){
        this.numMesa = nM;
        this.idRestaurante = idRes;
    }

    public int getId() {
        return id;
    }

    public int getNumMesa() {
        return numMesa;
    }

    public Restaurante getIdRestaurante(){
        return idRestaurante;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }

    public void setIdRestaurante(Restaurante idRes){
        this.idRestaurante = idRes;
    }


    
}
