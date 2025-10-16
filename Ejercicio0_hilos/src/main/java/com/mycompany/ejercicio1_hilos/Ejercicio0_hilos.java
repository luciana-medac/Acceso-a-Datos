/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio1_hilos;

/**
 *
 * @author PC218
 */
public class Ejercicio0_hilos {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        MiHilo h1 = new MiHilo();
        h1.start(); //se inicia el hilo
        
        MiHilo h2 = new MiHilo();
        h2.start(); //otro hilo en paralelo
        
        //DESDE EL MAIN NO LLAMO AL MÉTODO RUN, SE LLAMA AL MÉTODO START
        
        
        
    }
}
