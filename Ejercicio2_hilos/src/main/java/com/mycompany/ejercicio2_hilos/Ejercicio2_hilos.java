/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio2_hilos;

/**
 *
 * @author PC218
 */
public class Ejercicio2_hilos {

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        
        Hilo hilo1 = new Hilo(1);
        Hilo hilo2 = new Hilo(2);
        Hilo hilo3 = new Hilo(3);
        Hilo hilo4 = new Hilo(4);
        try{
            hilo1.start();
            hilo1.join(); //hace que los demás se esperen hasta que él acabe
            hilo2.start();
            hilo3.start();
            hilo4.start();
        } catch(InterruptedException e){
            System.out.println(e.getStackTrace());
        }
        
    }
}
