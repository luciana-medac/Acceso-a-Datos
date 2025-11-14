public class ServicioExtra {

    private int id;
    private String nombre;
    private int idReserva;
    private int idServicioExtra;

    public ServicioExtra(){

    }

    public ServicioExtra(int i, String n, int idRes, int idSer){
        this.id = i;
        this.nombre = n;
        this.idReserva = idRes;
        this.idServicioExtra = idSer;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public int getIdServicioExtra() {
        return idServicioExtra;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public void setIdServicioExtra(int idServicioExtra) {
        this.idServicioExtra = idServicioExtra;
    }
    
}
