import sun.awt.image.ImageWatched;

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
    private LinkedList<Llamada> listall = new LinkedList<Llamada>();
    private LinkedList<Factura> listafac = new LinkedList<Factura>();

    public Cliente(String nombre, String nif, Direccion dir, LocalDateTime fecha, Tarifa tarifa){
        this.nombre=nombre;
        this.nif=nif;
        this.dir=dir;
        this.fecha=fecha;
        this.tarifa=tarifa;
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

    public boolean addFactura(Factura factura){
        if(listafac.contains(factura)){
            return false;
        }
        listafac.add(factura);
        return true;
    }
    public LinkedList<Factura> getListafac(){
        return listafac;
    }
}
