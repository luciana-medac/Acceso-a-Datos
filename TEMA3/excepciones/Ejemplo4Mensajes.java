package excepciones;

public class Ejemplo4Mensajes {

    public static void main(String[] args) {
        
        int dividiendo = 10;
        int divisor = 0;

        try {
            int resultado = dividiendo / divisor;
            System.out.println(resultado);
            
        } catch (ArithmeticException e){
            System.out.println("Error aritmético: " + e.getMessage());
        } catch (Exception e) {
            // TODO: handle exception
            e.getStackTrace();
        } finally {
            //Lo que haya aqui se ejecuta si o si
        }
        

    }
    
}
