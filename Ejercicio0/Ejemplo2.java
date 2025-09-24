import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;

public class Ejemplo2 {

    public static void main(String[] args) {
        
        String path = ".\\Ejemplo2.txt";
        String pathEscritura = ".\\Ejemplo2w.txt";

        try{
            
            //Lee caracter por caracter el fichero
            FileReader lector = new FileReader(path);
            //Guarda el primer caracter del fichero y te lo muestra en ASCII --> si no se convierte
            int data;

            FileWriter escritor = new FileWriter(pathEscritura);
            
            //-1 hasta el final del fichero
            while ((data = lector.read()) != -1) {
                //Para que muestre el caracter y no el número(72) --> lo convertimos con (char)
                char frase = (char)data;
                escritor.write(frase);
                System.out.print(frase);
            }

            //Cerramos el lector
            lector.close();
            escritor.close();

            System.out.println("\nlectura completada");
        } catch (Exception e) {
            //TODO: handle exception
        }


    }
    
}
