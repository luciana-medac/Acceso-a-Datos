package com.mycompany.ejercicio4_hilos;

public class HiloAnimos extends Thread{
    
    String[] mensajes = {};
    int msj;
    int tiempo;
    
    public void run(){
        for (int i = 0; i < mensajes.length; i++) {
            msj = (int) (Math.random()* 4);
            System.out.println(mensajes[msj]);
            tiempo = (int)(2000 + Math.random()*3000);
            
            try{
                sleep(tiempo);
            } catch (InterruptedException e){
                e.getStackTrace();
            }
        }
    }
    

}
