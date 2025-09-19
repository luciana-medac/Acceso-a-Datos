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
        
        //Si la carpeta existe, que diga "la carpeta + nombre + ya existe"
        //Si no existe, decir que la carpeta se ha creado y poner la ruta relativa y absoluta
        if (fichero.renameTo(fichero2)) {
            System.out.println("El fichero " + fichero.getName() + " ya existe");
        } else {
            System.out.println("El fichero se ha movido correctamente");
            System.out.println("Ruta relativa: " + fichero2.getPath());
            System.out.println("Ruta absoluta: " + fichero2.getAbsolutePath());
        }

        } catch (Exception e) {
            System.out.println("Erroooor");
        }


        //Si la carpeta existe, que diga "la carpeta + nombre + ya existe"
        //Si no existe, decir que la carpeta se ha creado y poner la ruta relativa y absoluta
    }

    
}