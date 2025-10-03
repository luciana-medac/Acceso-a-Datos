package excepciones;

public class Ejemplo3StackOverFlowError {

    public static void main(String[] args) {
        //Es un error de que está constantemente llamando a la misma función
        recursiveFuntion();
    }
    public static void recursiveFuntion(){
        recursiveFuntion();
    }
    
}
