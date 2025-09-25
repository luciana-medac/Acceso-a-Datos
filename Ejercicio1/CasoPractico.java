package Ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.RandomAccess;


class CasoPractico {

    public static void main(String[] args) {

        try {
        //VARIABLES
        int i = 0; //--> inicializa el contador de bloques
        String linea;
        LocalDateTime fechaActual = LocalDateTime.now(); // --> variable de tipo fecha para poner la fecha actual
        
        //Creamos los ficheros
        File fichero = new File("archivo_origen.txt");
        File fichero2 = new File("archivo_destino.txt");
        //Guardamos las rutas de los ficheros
        String path = fichero.getAbsolutePath();
        String path2 = fichero2.getAbsolutePath();

        if (fichero.exists() && fichero2.exists()) {
            System.out.println("Los ficheros ya existen");
        } else {
            System.out.println("Se ha creado correctamente");
        }
        
        //Accedemos a los fichero, en modo lectura y escritura
        RandomAccessFile file = new RandomAccessFile(path, "rw");
        RandomAccessFile file2 = new RandomAccessFile(path2, "rw");
        
        BufferedReader br = new BufferedReader(new FileReader("archivo_origen.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("archivo_destino.txt"));

        //Leemos el fichero y mientras se va escribiendo en otro
        while ((linea = br.readLine()) != null){
            bw.write(linea);
            i++;
            System.out.println("Fin copia bloque " + i);
        }

        bw.write("Última modificacion: " + fechaActual);

        br.close();
        bw.close();

        } catch (FileNotFoundException e){
            System.out.println("Problemas al acceder al fichero");
        }
        catch (Exception e) {
            System.out.println("Ha ocurrido un error");
        }


    }

}