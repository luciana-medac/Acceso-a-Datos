package com.mycompany.ejercicio2_hilos;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Hilo extends Thread{
    
    int numHilo;
    
    public Hilo(int n){
        this.numHilo = n;
    }
    
    @Override
    public void run(){
        
        for (int i = 0; i < 11; i++) {
            System.out.println("Hilo " + numHilo + ": " + i);
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                //Salta cuando algún hilo se interrumpe
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
