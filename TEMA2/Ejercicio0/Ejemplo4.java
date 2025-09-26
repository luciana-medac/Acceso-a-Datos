package Ejercicio0;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.LineNumberReader;

public class Ejemplo4 {

    public static void main(String[] args) {

        try {
            // Coger una linea y que solo lea el número
            String ruta = "C:\\Users\\PC218\\Documents\\GitHub\\Acceso-a-Datos\\TEMA2\\Ejercicio0\\entrada.txt";
            
            DataInputStream data = new DataInputStream(new FileInputStream(ruta));

            int entero = data.readInt();
            int entero1 = data.readInt();

            
        
        
        
        } catch (Exception e) {

        }

    }

}
