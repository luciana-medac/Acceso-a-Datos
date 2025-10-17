/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio4_hilos;

import java.util.Scanner;

/**
 *
 * @author PC218
 */
public class Ejercicio4_hilos {

    public static void main(String[] args) {
        
        /*
        Crea un juego de adivinar el número, en el que el programa genera un número aleatorio
        entre el 0 y el 100 (sin mostrarlo al usuario) y va pidiendo números al usuario
        indicándole "mayor" o "menor" hasta que este consiga adivinarlo
        
        Mientras, otro hilo tendrá una marcha atrás, dandole al jugador tan solo 30s
        para adivinar el número
        */
        
        HiloJuego hJ = new HiloJuego();
        HiloContador hC = new HiloContador();
        HiloAnimos hA = new HiloAnimos();
        
        hC.start();
        hJ.start();
        hA.start();
        
//        if(hC.isAlive()){
//            hJ.start();
//            hA.start();
//        } else {
//            hJ.interrupt();
//        }

        
        
    }
}
