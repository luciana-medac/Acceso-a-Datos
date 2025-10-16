package com.mycompany.ejercicio1_hilos;

public class MiHilo extends Thread{
    
    public void run(){
        System.out.println("Ejecutando en un hilo: " + getName());
    }

}
