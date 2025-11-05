package com.example.demo;

import java.util.Date;

public class Pedido {

    private int id;
    private Date fecha;
    private int cantidad;
    private double importe;
    private Customer customer;
    private Producto product;

    public Pedido(){
    }

    public Pedido(Date f, int c, double i){
        this.fecha = f;
        this.cantidad = c;
        this.importe = i;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public double getImporte() {
        return importe;
    }
    public void setImporte(double importe) {
        this.importe = importe;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Producto getProduct() {
        return product;
    }
    public void setProduct(Producto product) {
        this.product = product;
    }

    
    
    
}
