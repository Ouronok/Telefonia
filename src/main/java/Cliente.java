import java.time.LocalDateTime;
import java.util.LinkedList;

/**
 * Created by al342052 on 21/02/2017.
 */
public abstract class Cliente {
    private String nombre;
    private String nif;
    private Direccion dir;
    private LocalDateTime fecha;
    private Tarifa tarifa;
    private LinkedList<Llamada> listall;

    public Cliente(String nombre, String nif, Direccion dir, LocalDateTime fecha, Tarifa tarifa , LinkedList<Llamada> listall){
        this.nombre=nombre;
        this.nif=nif;
        this.dir=dir;
        this.fecha=fecha;
        this.tarifa=tarifa;
        this.listall=listall;
    }

    public LocalDateTime getFecha(){
        return fecha;
    }

    public LinkedList<Llamada> getLlamadaPeriodo(LocalDateTime[] periodo) {
        LinkedList<Llamada> retList = new LinkedList<Llamada>();
        for (Llamada llact : listall) {
            if (llact.getFecha().isAfter(periodo[1]) && llact.getFecha().isBefore(periodo[0])) {
                retList.add(llact);
            }
        }
        return retList;
    }
    public void swpTarifa(Tarifa nTarifa) {
        this.tarifa = nTarifa;
    }

    public boolean addLlamada(Llamada llamada){
        if(listall.contains(llamada)){
            return false;
        }
        listall.add(llamada);
        return true;
    }

    public LinkedList<Llamada> getListall(){
        return listall;
    }

    public String getNif(){
        return nif;
    }

    public Tarifa getTarifa(){
        return tarifa;
    }
}
