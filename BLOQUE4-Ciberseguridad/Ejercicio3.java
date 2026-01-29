import java.util.regex.Pattern;

public class Ejercicio3 {

    public static void main(String[] args) {
        
        System.out.println(validarMatricula("8832-FWD"));

    }

    public static boolean validarMatricula(String ma){
        String regex_matricula= "^[0-9]{4}(-)[A-Z]{3}$";
        // "[0-9]{4}-[QWRTYPSDFGHJKLXCVBNM]{3}"

        return Pattern.matches(regex_matricula, ma);
    }
    
}
