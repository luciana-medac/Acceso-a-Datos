public class Cliente {

    private int id;
    private String nombre;
    private String telefono;

    public Cliente(){

    }

    public Cliente(int i, String n, String t){

        this.id = i;
        this.nombre = n;
        this.telefono = t;

    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
}
