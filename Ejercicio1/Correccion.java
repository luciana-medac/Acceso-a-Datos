package Ejercicio1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Correccion {
    
    public static void main(String[] args) {
        
        try {

            //TAMAÑO DEL BUFFER (DEL ARRAY)
            int bufferSize = 12;

            //esto sirve para guardar en memoria el txt
            BufferedInputStream bIs = new BufferedInputStream(
                new FileInputStream("C:\\Users\\molin\\Documents\\GitHub\\Acceso-a-Datos\\Ejercicio1\\archivo_origen.txt"));
            BufferedOutputStream bOs = new BufferedOutputStream(
                new FileOutputStream("C:\\Users\\molin\\Documents\\GitHub\\Acceso-a-Datos\\Ejercicio1\\archivo_destino.txt"));
            
            //CREAMOS UN ARRAY DE BYTES PARA ALMACENAR CADA BLOQUE LEÍDO
            byte[] buffer = new byte[bufferSize];
            int info;
            int blockNumber = 1;

            //LEEMOS EL TXT
            while((info = bIs.read(buffer)) != -1){
                //CONVERTIMOS EL BLOQUE LEÍDO EN TEXTO (si es un archivo de texto)
                String contenido = new String(buffer, 0, info);  //Creo un "objeto" String y le paso por parámetro el array, la posición por la que empieza 
                                                                        //y la información que es la linea que va leyendo
                System.out.println("Contenido del bloque: " + blockNumber + " (bytes=" + info + ");");
                System.out.println(contenido);
                System.out.println("Fin bloque " + blockNumber);
                blockNumber++;

                //Copiamos el contenido de origen a el txt destino
                bOs.write(buffer, 0, info);
                
            }
            
            bIs.close();
            bOs.close();

        } catch (Exception e){
            e.printStackTrace();
        }

    }

}
