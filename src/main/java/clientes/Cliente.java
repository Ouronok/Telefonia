package clientes;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedList;
import datos.Dato;
import tarifas.Tarifa;
import datos.Direccion;
import pago.Factura;
import pago.Llamada;


public abstract class Cliente implements Dato, Serializable {
    private String nombre;
    private String nif;
    private String email;
    private Direccion dir;
    private LocalDateTime fecha;
    private Tarifa tarifa;
    private LinkedList<Llamada> listall;
    private LinkedList<Factura> listafac;

    public Cliente(String nombre, String nif, String email, Direccion dir, LocalDateTime fecha, Tarifa tarifa) {
        this.nombre = nombre;
        this.email = email;
        this.nif = nif;
        this.dir = dir;
        this.fecha = fecha;
        this.tarifa = tarifa;
        this.listall = new LinkedList<>();
        this.listafac = new LinkedList<>();
    }

    public LinkedList<Llamada> getLlamadaPeriodo(LocalDateTime[] periodo) {
        LinkedList<Llamada> retList = new LinkedList<>();
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

    public boolean addLlamada(Llamada llamada) {
        if (listall.contains(llamada)) {
            return false;
        }
        listall.add(llamada);
        return true;
    }

    public LinkedList<Llamada> getListall() {
        return listall;
    }

    public String getNif() {
        return nif;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public boolean addFactura(Factura factura) {
        if (listafac.contains(factura)) {
            return false;
        }
        listafac.add(factura);
        return true;
    }

    public LinkedList<Factura> getListafac() {
        return listafac;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n" + "NIF: " + nif + "\n" + "Email: "
        + email + "\n" +  "Direccion: " + dir.toString() + "\n" + fecha.toString() + "\n" + tarifa.toString();
    }

    public LocalDateTime getFecha(){
        return fecha;
    }
}
