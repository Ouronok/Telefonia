import java.time.LocalDateTime;
import java.util.LinkedList;


public abstract class Cliente implements Dato {
    private String nombre;
    private String nif;
    private String email;
    private Direccion dir;
    private LocalDateTime fecha;
    private Tarifa tarifa;
    private LinkedList<Llamada> listall = new LinkedList<>();
    private LinkedList<Factura> listafac = new LinkedList<>();

    Cliente(String nombre, String nif, String email, Direccion dir, LocalDateTime fecha, Tarifa tarifa) {
        this.nombre = nombre;
        this.email = email;
        this.nif = nif;
        this.dir = dir;
        this.fecha = fecha;
        this.tarifa = tarifa;
    }

    LinkedList<Llamada> getLlamadaPeriodo(LocalDateTime[] periodo) {
        LinkedList<Llamada> retList = new LinkedList<>();
        for (Llamada llact : listall) {
            if (llact.getFecha().isAfter(periodo[1]) && llact.getFecha().isBefore(periodo[0])) {
                retList.add(llact);
            }
        }
        return retList;
    }

    void swpTarifa(Tarifa nTarifa) {
        this.tarifa = nTarifa;
    }

    boolean addLlamada(Llamada llamada) {
        if (listall.contains(llamada)) {
            return false;
        }
        listall.add(llamada);
        return true;
    }

    LinkedList<Llamada> getListall() {
        return listall;
    }

    String getNif() {
        return nif;
    }

    Tarifa getTarifa() {
        return tarifa;
    }

    String getEmail() {
        return email;
    }

    boolean addFactura(Factura factura) {
        if (listafac.contains(factura)) {
            return false;
        }
        listafac.add(factura);
        return true;
    }

    LinkedList<Factura> getListafac() {
        return listafac;
    }

    @Override
    public String toString() {
        return nombre + "," + nif + "\n" + email + "\n" + dir.toString() + "\n" + fecha.toString() + "\n" + tarifa.toString();
    }

    public LocalDateTime getFecha(){
        return fecha;
    }
}
