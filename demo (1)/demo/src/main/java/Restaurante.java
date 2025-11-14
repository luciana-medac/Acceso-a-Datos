public class Restaurante {

    private int id;
    private String nombre;

    public Restaurante(){

    }

    public Restaurante(int i, String n){
        this.id = i;
        this.nombre = n;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
