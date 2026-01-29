import java.util.regex.Pattern;

public class Ejercicio1 {

    public static void main(String[] args) {
        
        // Verificar si el DNI tiene 8 numeros y una letra

        System.out.println( validarDNI("99687766C"));


        // REGEX ES AGNOSTICO AL LENGUAJE -> es exactamente igual en todos los lenguajes

    }

    public static boolean validarDNI(String dni){

        String regex_dni = "^[0-9]{8}[a-zA-Z]{1}$"; // Si tiene 8 números entre 0-9 y 1 letra entre la a-z minuscula
                                                    // ^ -> signo que indica dónde empieza la cadena
                                                    // $ -> signo que indica dónde acaba la cadena
        // Al método Pattern.matches se le pasa la condición (regex) y el dato que se quiere verificar
        return Pattern.matches(regex_dni, dni);



    }
}