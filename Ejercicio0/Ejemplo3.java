import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Ejemplo3 {
    public static void main(String[] args) {
        
        String path = ".\\Ejemplo2.txt";
        String pathEscritura = ".\\Ejemplo2w.txt";

        try{
        
            FileInputStream entrada = new FileInputStream(path);
            FileOutputStream escritura = new FileOutputStream(pathEscritura);

            int data;

            while ((data = entrada.read()) != -1) {
                
                char frase = (char)data;
                escritura.write(frase);
                System.out.print(frase);

            }

            entrada.close();
            escritura.close();
        } catch (Exception e){
            //TODO: handle exception
        }

    }
    
}
