package excepciones;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Ejemplo1Checked {
    
    public static void main(String[] args) {
        
        try{
        FileReader file = new FileReader("archivo");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }

}
