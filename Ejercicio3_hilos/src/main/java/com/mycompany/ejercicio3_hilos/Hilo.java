package com.mycompany.ejercicio3_hilos;

public class Hilo extends Thread {
    
    int num;
    int num2;
    
    public Hilo(int n1, int n2){
        
        this.num = n1;
        this.num2 = n2;
    }
    
    @Override
    public void run(){
        System.out.println("Suma Total: " + (this.num + this.num2));
    }

}
