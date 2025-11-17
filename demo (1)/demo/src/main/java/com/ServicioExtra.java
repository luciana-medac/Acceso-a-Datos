package com;
import java.util.HashSet;
import java.util.Set;

public class ServicioExtra {

    private int id;
    private String nombre;
    private Reserva idReserva;
    private Set<Reserva> reservas = new HashSet<>();

    public ServicioExtra() {

    }

    public ServicioExtra(String n) {
        this.nombre = n;
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


    public Set<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(Set<Reserva> reservas) {
        this.reservas = reservas;
    }

}
