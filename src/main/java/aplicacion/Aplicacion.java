package aplicacion;

import clientes.Cliente;
import clientes.Empresa;
import clientes.Particular;
import datos.Dato;
import datos.Direccion;
import tarifas.*;
import excepciones.BadPeriod;
import excepciones.NotContained;
import excepciones.NotCreated;
import pago.Factura;
import pago.Llamada;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedList;


public class Aplicacion implements Serializable {
    private final LocalDateTime fact = LocalDateTime.now();
    private LinkedList<Cliente> clientes = new LinkedList<>();

    boolean addCliente(String nombre, String nif, String email, Direccion dir, Double precio) {
        Tarifa tarifa = new TarifaBasica(precio);
        Empresa cliente = new Empresa(nombre, nif, email, dir, fact, tarifa);

        return addCliente(cliente);
    }

    boolean addCliente(String nombre, String apellidos, String nif, String email, Direccion dir, Double precio) {
        Tarifa tarifa = new TarifaBasica(precio);
        Particular cliente = new Particular(nombre, apellidos, nif, email, dir, fact, tarifa);
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

    boolean swpTarifa(Cliente cliente, double precio) {
        Tarifa tarifa = new TarifaBasica(precio);
        if (clientes.contains(cliente)) {
            cliente.swpTarifa(tarifa);
            return true;
        }
        return false;
    }

    Cliente getCliente(String nif) throws NotContained {
        for (Cliente cAct : clientes) {
            if (cAct.getNif().equals(nif)) {
                return cAct;
            }
        }
        throw new NotContained();
    }

    public LinkedList<Cliente> getClientes() {
        return clientes;
    }

    boolean addLlamada(String tlf, int duracion, LocalDateTime fecha, Cliente cliente) {
        return clientes.contains(cliente) && cliente.addLlamada(new Llamada(tlf, duracion, fecha));
    }

    public LinkedList<Llamada> getLlamadas(Cliente cliente) {
        if (clientes.contains(cliente)) {
            return cliente.getListall();
        }
        return null;
    }

    boolean emitirFactura(Cliente cliente, LocalDateTime[] intervalo) throws BadPeriod, NotContained {
        if (intervalo[0].isAfter(intervalo[1])) {
            throw new BadPeriod();
        }

        if (!clientes.contains(cliente)) {
            throw new NotContained();
        }
        cliente.addFactura(new Factura(fact, intervalo[0], intervalo[1], cliente, cliente.getTarifa()));
        return true;
    }

    Factura getFactura(int cod) throws NotCreated {
        for (Cliente cliac : clientes) {
            for (Factura faac : cliac.getListafac()) {
                if (faac.getFID() == cod) {
                    return faac;
                }
            }
        }
        throw new NotCreated();
    }

    public LinkedList<Factura> getFacturas(Cliente cliente) {
        return cliente.getListafac();
    }

    public <T extends Dato> LinkedList<T> getList(LinkedList<T> list, LocalDateTime fecha1, LocalDateTime fecha2) throws BadPeriod {
        if(fecha1.isAfter(fecha2)) throw new BadPeriod();

        LinkedList<T> retList = new LinkedList<>();
        for(T elem : list){
            LocalDateTime fecha = elem.getFecha();
            if(fecha.isAfter(fecha1) && fecha.isBefore(fecha2)){
                retList.add(elem);
            }
        }
        return retList;
    }
    public Direccion crearDir(String cp, String provincia, String poblacion){
        return new Direccion(cp,provincia,poblacion);
    }

}
