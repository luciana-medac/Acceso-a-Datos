import java.io.FileReader;
import java.io.LineNumberReader;

public class Ejemplo3 {

    public static void main(String[] args) {
        
        try{

            LineNumberReader ln = new LineNumberReader(new FileReader("C:\\Users\\PC218\\Documents\\GitHub\\Acceso-a-Datos\\TEMA2\\EjemploToken.txt"));

            //Guarda el valor de cada linea
            String linea = ln.readLine();
            while (linea != null) {
                //getLineNumber te dice el número de linea
                System.out.println("Contenido de la linea número: " + ln.getLineNumber());
                System.out.println(linea);
                linea = ln.readLine(); //es igual que si lo pusieramos dentro del bucle
            }

            ln.close();

        } catch (Exception e){

        }

    }
    
}
