import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ejemplo4 {

    public static void main(String[] args) {
        
        try{
            //CREAMOS EL FICHERO
            File fichero = new File(".\\datos.txt");
            Scanner sc = new Scanner(System.in);
            //GUARDAMOS EL PATH
            String path = fichero.getAbsolutePath();
            //COMPROBAMOS SI EL FICHERO EXISTE Y SI NO, SE CREA CORRECTAMENTE
                if (fichero.exists()) {
                    System.out.println("El fichero ya existe");
                } else {
                    System.out.println("Se ha creado correctamente");
                }
            
            //ESCRIBIMOS EL ABECEDARIO EN EL FICHERO
            FileWriter escritor = new FileWriter(path);
            escritor.write("ABCDEFGHIJKLMNÑOPQ");
            //CERRAMOS EL WRITER
            escritor.close();

            //ABRIMOS EL ARCHIVO EN MODO LECTURA Y ESCRITURA
            RandomAccessFile file = new RandomAccessFile(path, "rw");
            
            //PREGUNTAMOS AL USUARIO
            System.out.println("Escribe la posicion del caracter a modificar(1-27): ");
            long eleccion = sc.nextLong();
            sc.nextLine();
            
            //POSICION QUE INDIQUEMOS
            file.seek(eleccion - 1);
            
            //COMPROBACIÓN DEL DATO A MODIFICAR
            int unByte = file.read();
            System.out.println((char) unByte);

            //PEDIMOS EL NUEVO DATO
            System.out.println("Escribe el nuevo dato: ");
            String eleccion2 = sc.nextLine();
            //MODIFICAMOS EL TXT CON EL DATO NUEVO
            file.writeBytes(eleccion2);
            
            file.close();
            escritor.close();

        } catch (Exception e) {
            
        }


    }

}
