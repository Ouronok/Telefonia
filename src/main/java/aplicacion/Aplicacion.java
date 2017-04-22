package aplicacion;

import clientes.Cliente;
import clientes.Empresa;
import clientes.Particular;
import datos.Dato;
import excepciones.BadPeriod;
import excepciones.NotContained;
import excepciones.NotCreated;
import pago.Factura;
import pago.Llamada;
import tarifas.Tarifa;
import tarifas.TarifaBasica;
import tarifas.TarifaDomingo;
import tarifas.TarifaTardes;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.LinkedList;


public class Aplicacion implements Serializable {
    private final LocalDateTime fact = LocalDateTime.now();
    private Factoria factoria = new Factoria();
    private LinkedList<Cliente> clientes = factoria.creaLista();

    boolean addCliente(String nombre, String nif, String email, String[] dir, Double precio) {
        Empresa cliente = factoria.creaEmpresa(nombre, nif, email, factoria.crearDir(dir), fact, precio);
        return addCliente(cliente);
    }

    boolean addCliente(String nombre, String apellidos, String nif, String email, String[] dir, Double precio) {
        Particular cliente = factoria.creaParticular(nombre, apellidos, nif, email, factoria.crearDir(dir), fact, precio);
        return addCliente(cliente);
    }

    public boolean addCliente(Cliente cliente) {
        for (Cliente cliac : clientes) {
            if (cliac.getNif().equals(cliente.getNif())) {
                return false;
            }
        }
        clientes.add(cliente);
        return true;
    }

    boolean delCliente(Cliente cliente) {
        if (clientes.contains(cliente)) {
            clientes.remove(cliente);
            return true;
        }
        return false;
    }

    boolean swpPrecio(Cliente cliente, double precio) {
        if (clientes.contains(cliente)) {
            if(cliente.getTarifa() instanceof TarifaBasica){
                ((TarifaBasica) cliente.getTarifa()).swpPrecio(precio);
                return true;
            }
        }
        return false;
    }

    Cliente getCliente(String nif) throws NotContained {
        for (Cliente cAct : clientes) {
            if (cAct.getNif().equals(nif)) {
                return cAct;
            }
        }
        throw factoria.creaNotContained();
    }

    public LinkedList<Cliente> getClientes() {
        return clientes;
    }

    boolean addLlamada(String tlf, int duracion, LocalDateTime fecha, Cliente cliente) {

        return clientes.contains(cliente) && cliente.addLlamada(factoria.creaLlamada(tlf, duracion, fecha,cliente.getTarifa()));
    }



    public LinkedList<Llamada> getLlamadas(Cliente cliente) {
        if (clientes.contains(cliente)) {
            return cliente.getListall();
        }
        return null;
    }

    void emitirFactura(Cliente cliente, LocalDateTime[] intervalo) throws BadPeriod, NotContained {
        if (intervalo[0].isAfter(intervalo[1])) {
            throw factoria.creaBadPeriod();
        }

        if (!clientes.contains(cliente)) {
            throw factoria.creaNotContained();
        }
        double importe = calcImp(cliente, intervalo);
        cliente.addFactura(factoria.creaFactura(fact, intervalo, importe, cliente.getTarifa()));
    }

    private double calcImp(Cliente cliente, LocalDateTime[] intervalo) {
        double importe=0;
        for(Llamada llac : cliente.getListall()){
            if(llac.getFecha().isAfter(intervalo[0]) && llac.getFecha().isBefore(intervalo[1])){
                importe+= cliente.getTarifa().precioLlamada(llac);
            }
        }
        return importe;
    }

    Factura getFactura(int cod) throws NotCreated {
        for (Cliente cliac : clientes) {
            for (Factura faac : cliac.getListafac()) {
                if (faac.getFID() == cod) {
                    return faac;
                }
            }
        }
        throw factoria.creaNotCreated();
    }

    public LinkedList<Factura> getFacturas(Cliente cliente) {
        return cliente.getListafac();
    }

    public <T extends Dato> LinkedList<T> getList(LinkedList<T> list, LocalDateTime fecha1, LocalDateTime fecha2) throws BadPeriod {
        if (fecha1.isAfter(fecha2)) throw factoria.creaBadPeriod();

        LinkedList<T> retList = factoria.creaLista();
        for(T elem : list){
            LocalDateTime fecha = elem.getFecha();
            if(fecha.isAfter(fecha1) && fecha.isBefore(fecha2)){
                retList.add(elem);
            }
        }
        return retList;
    }


}
