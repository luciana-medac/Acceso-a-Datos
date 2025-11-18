package com.example.demo;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class Reserva {

    private int id;
    private Date fecha;
    private Mesa idMesa;
    private Cliente idCliente;
    private Set<ServicioExtra> serviciosExtras = new HashSet<>();

    

    public Reserva(){

    }

    public Reserva(Date f, Mesa idM, Cliente idC){
        this.fecha = f;
        this.idMesa = idM;
        this.idCliente = idC;
    }

    public int getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public Mesa getIdMesa(){
        return idMesa;
    }

    public Cliente getIdCliente(){
        return idCliente;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setIdMesa(Mesa idM){
        this.idMesa = idM;
    }

    public void setIdCliente(Cliente idC){
        this.idCliente = idC;
    }
    
    public Set<ServicioExtra> getServiciosExtras() {
        return serviciosExtras;
    }

    public void setServiciosExtras(Set<ServicioExtra> serviciosExtras) {
        this.serviciosExtras = serviciosExtras;
    }

}
