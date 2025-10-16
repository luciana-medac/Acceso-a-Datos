package com.mycompany.ejercicio4_hilos;

import java.util.Scanner;

public class HiloJuego extends Thread{
    
    @Override
    public void run(){
        
        int RandomNum = (int)(Math.random() * 101);
        int numUsuario;
        do {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Escribe un numero: ");
        numUsuario = Integer.parseInt(sc.nextLine());
        
        if (numUsuario > RandomNum) {
            System.out.println("Menor");
        } else if(numUsuario < RandomNum){
            System.out.println("Mayor");
        } else {
            System.out.println("Adivinaste!! Toma un patata");
        }
        } while (numUsuario != RandomNum);
        
        
    }

}
