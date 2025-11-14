import java.util.Date;

public class Reserva {

    private int id;
    private Date fecha;
    private Mesa idMesa;
    private Cliente idCliente;

    public Reserva(){

    }

    public Reserva(int i, Date f, Mesa idM, Cliente idC){
        this.id = i;
        this.fecha = f;
        this.idMesa = idM;
        this.idCliente = idC;
    }

    public int getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public Mesa getIdMesa(){
        return idMesa;
    }

    public Cliente getIdCliente(){
        return idCliente;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setIdMesa(Mesa idM){
        this.idMesa = idM;
    }

    public void setIdCliente(Cliente idC){
        this.idCliente = idC;
    }

}
