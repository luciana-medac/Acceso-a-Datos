package com.mycompany.javadoc;

/**Clase para instanciar personas
*  @author luciana
*/
public class Persona {
    
    private String nombre;
    private int edad;
    
    public Persona(String n, int e){
        this.nombre = n;
        this.edad = e;
    }
    
    /**Este metodo indica si la persona es mayor de edad o no
    * @return devuelve true si es mayor de edad y false si no
    */
    public boolean mayorEdad(){
        
        if(this.edad >= 18){
            return true;
        }else {
            return false;
        }
    }

}
