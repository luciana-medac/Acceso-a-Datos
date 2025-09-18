import java.io.File;

public class Ejemplo1 {

    public static void main(String[] args) {

        try{

        File fichero = new File(".\\Ejemplo1.txt");
        //fichero.createNewFile();
        //fichero.delete(); --> borrar un fichero

        //String nombreCarpeta = "backup";
        //File carpeta = new File(".\\", nombreCarpeta);
        //carpeta.mkdirs(); --> para crear la carpeta
        
        File fichero2 = new File(".\\backup\\backupEjercicio1.txt");
        fichero.renameTo(fichero2);

        } catch (Exception e) {
            System.out.println("Erroooor");
        }


        //Si la carpeta existe, que diga "la carpeta + nombre + ya existe"
        //Si no existe, decir que la carpeta se ha creado y poner la ruta relativa y absoluta
    }

    
}