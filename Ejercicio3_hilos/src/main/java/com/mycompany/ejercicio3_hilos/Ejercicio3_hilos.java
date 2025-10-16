/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio3_hilos;

import java.util.Scanner;

/**
 *
 * @author PC218
 */
public class Ejercicio3_hilos{

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        Scanner sc = new Scanner(System.in);
        int n1;
        int n2;
        n1 = Integer.parseInt("Introduce un numero: " + sc.nextLine());
        n2 = Integer.parseInt("Introduce un numero: " + sc.nextLine());
        
        Hilo hSumar = new Hilo(n1,n2);
        HiloRestar hResta = new HiloRestar(n1 , n2);
        HiloMultiplicar hMult = new HiloMultiplicar(n1 , n2);
        HiloDividir hDiv = new HiloDividir(n1 , n2);
        
        hSumar.start();
        hResta.start();
        hMult.start();
        hDiv.start();
        
    }
}
