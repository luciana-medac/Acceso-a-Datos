import java.util.regex.Pattern;

public class Ejercicio2 {

    public static void main(String[] args) {
    
        // Validar IP local:
        // Empieza por 192.168
        // Sigue por un número
        // Sigue por un punto
        // Sigue por dos números
        System.out.println(validarIP("192.168.1.13"));

    }

    public static boolean validarIP(String ip){

        String regex_ip = "^(192.168.)[0-9]{1,3}(.)[0-9]{1,3}$" ;
        // "^(192\\.168\\.)[0-9]{1,3}(\\.)[0-9]{1,3}$" --> es recomendable hacerlo así para que el punto no tenga más funciones
        return Pattern.matches(regex_ip, ip);
    }
    
}
