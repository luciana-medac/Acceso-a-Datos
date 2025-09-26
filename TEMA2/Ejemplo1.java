import java.io.StreamTokenizer;
import java.io.StringReader;

public class Ejemplo1 {

    public static void main(String[] args) {
        
        //Nos permite que mediante condicionales nos diga cierta información
        StreamTokenizer st = new StreamTokenizer(new StringReader("Hola mi edad es 21"));
        try{

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

        }catch(Exception e){
            e.getStackTrace();
        }

    }
    
}
