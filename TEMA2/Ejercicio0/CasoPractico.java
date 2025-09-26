package Ejercicio0;

import java.io.FileReader;
import java.io.LineNumberReader;
import java.io.StreamTokenizer;
import java.util.stream.Stream;
import java.io.StringReader;
public class CasoPractico {

    public static void main(String[] args) {

        try {

            String ruta = "C:\\Users\\PC218\\Documents\\GitHub\\Acceso-a-Datos\\TEMA2\\Ejercicio0\\entrada.txt";
            LineNumberReader ln = new LineNumberReader(new FileReader(ruta));

            String linea;
            while ((linea = ln.readLine()) != null) {
                int contadorP = 0;
                int contadorN = 0;
                //StringReader toma de referencia el String linea
                StreamTokenizer st = new StreamTokenizer(new StringReader(linea));
                while (st.nextToken() != StreamTokenizer.TT_EOF) {
                    if (st.ttype == StreamTokenizer.TT_WORD) {
                        contadorP++;
                    } else if (st.ttype == StreamTokenizer.TT_NUMBER) {
                        contadorN++;
                    }
                }
                System.out.println("Linea:" + " " + ln.getLineNumber() + " " + linea);
                System.out.println("Palabras: " + contadorP  + ", Numero: " + contadorN);
            }

            ln.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
