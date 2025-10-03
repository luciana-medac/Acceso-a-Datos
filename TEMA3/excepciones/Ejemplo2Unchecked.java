package excepciones;

public class Ejemplo2Unchecked {

    public static void main(String[] args) {
        
        int[] numeros = {1,2,3};

        System.out.println(numeros[5]);
        
        //Esto da error pero en tiempo de ejecución, no en compilación

        String texto = null;
        int longitud = texto.length();
        System.out.println(longitud);
        System.out.println("Esto no se ejecuta");

    }
    
}
