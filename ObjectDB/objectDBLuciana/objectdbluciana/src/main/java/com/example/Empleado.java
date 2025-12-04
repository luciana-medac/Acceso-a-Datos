package com.example;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Empleado extends Persona {
    private double salario;

    @ManyToOne
    Departamento departamento;

    // Añadido
    Ciudad ciudad;

    public Empleado() {}

    public Empleado(int id, String nombre, int edad, double salario, Departamento d, Ciudad c) {
        super(id, nombre, edad);
        this.salario = salario;
        this.departamento = d;
        this.ciudad = c;
    }  
}