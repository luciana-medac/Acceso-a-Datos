package com.mycompany.ejercicio4_hilos;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HiloContador extends Thread{
    
    @Override
    public void run(){
        
        for (int i = 30; i > 0; i--) {
            System.out.println("Te quedan: " + i + " seg");;
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloContador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

}
