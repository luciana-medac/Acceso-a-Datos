import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StreamTokenizer;
import java.io.StringReader;

public class Ejemplo2 {

    public static void main(String[] args) {

        
        
        try{
            //PARA LEER UN FICHERO
            StreamTokenizer st = new StreamTokenizer(
                new FileReader(".\\EjemploToken.txt"));
            //Para que te tenga en cuenta lo de salto de linea
            st.eolIsSignificant(true);
            //Que lea hasta el final de fichero
            while (st.nextToken() != StreamTokenizer.TT_EOF){
                //Si se encuentra una palabra
                if (st.ttype == StreamTokenizer.TT_WORD ) {
                    //Para que me lo muestre por pantalla es .sval (el valor)
                    System.out.println("Palabra - " + st.sval);
                //Si se encuentra un número
                } else if (st.ttype == StreamTokenizer.TT_NUMBER) {
                    //Para que me muestre el valor por pantalla SI ES NÚMERO es .nval
                    System.out.println("Numero - " + st.nval);
                //Si se encuentra con el final de linea (EOL)
                } else if (st.ttype == StreamTokenizer.TT_EOL) {
                    System.out.println("Fin");
                }
            }

        } catch (FileNotFoundException e){
            System.out.println("Fichero no encontrado");
        }
        catch(Exception e){
            e.getStackTrace();
        }

    }
    
}
