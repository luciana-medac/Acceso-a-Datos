package Ejercicio2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CasoPractico {

    public static void main(String[] args) {
        
        try{

            BufferedInputStream bIs = new BufferedInputStream(
                new FileInputStream("C:\\Users\\PC218\\Documents\\GitHub\\Acceso-a-Datos\\Ejercicio2\\davante.jpg"));
            BufferedOutputStream bOs = new BufferedOutputStream(
                new FileOutputStream("C:\\Users\\PC218\\Documents\\GitHub\\Acceso-a-Datos\\Ejercicio2\\davantecopia.jpg"));

            byte [] buffer = new byte[1024];
            int bytesLeidos;
            int contador = 0;

            //ACUERDATE QUE EL READ LLEVA POR PARÁMETRO EL ARRAY
            while ((bytesLeidos = bIs.read(buffer)) != -1) {
                bOs.write(buffer, 0, bytesLeidos);
                System.out.println("Se ha copiado el bloque: " + contador + ", bytes: " + bytesLeidos);
                contador++;
            }

            bIs.close();
            bOs.close();

        } catch (Exception e){

        }
        

    }
    
}
