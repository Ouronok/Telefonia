package aplicacion;

import clientes.Cliente;
import clientes.Empresa;
import clientes.Particular;
import datos.Dato;
import datos.Direccion;
import datos.Tarifa;
import excepciones.BadPeriod;
import excepciones.NotContained;
import excepciones.NotCreated;
import pago.Factura;
import pago.Llamada;

import java.time.LocalDateTime;
import java.util.LinkedList;


public class Aplicacion {
    private final LocalDateTime fact = LocalDateTime.now();
    private LinkedList<Cliente> clientes = new LinkedList<>();

    boolean addCliente(String nombre, String nif, String email, Direccion dir, Double precio) {
        Tarifa tarifa = new Tarifa(precio);
        Empresa cliente = new Empresa(nombre, nif, email, dir, fact, tarifa);

        return addCliente(cliente);
    }

    boolean addCliente(String nombre, String apellidos, String nif, String email, Direccion dir, Double precio) {
        Tarifa tarifa = new Tarifa(precio);
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
        Tarifa tarifa = new Tarifa(precio);
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

    boolean addLlamada(Llamada llamada, Cliente cliente) {
        return clientes.contains(cliente) && cliente.addLlamada(llamada);
    }

    LinkedList<Llamada> getLlamadas(Cliente cliente) {
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
                if (faac.getFid() == cod) {
                    return faac;
                }
            }
        }
        throw new NotCreated();
    }

    LinkedList<Factura> getFacturas(Cliente cliente) {
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

    LinkedList<Cliente> getClientes(LocalDateTime fecha1, LocalDateTime fecha2) throws BadPeriod {

        //FECHAS NO VALIDAS
        if (fecha2.isAfter(fecha1)) throw new BadPeriod(); //Añadir excepción
        return getList(clientes,fecha1,fecha2);
    }

    public LinkedList<Llamada> getLlamadas(Cliente cliente, LocalDateTime fecha1, LocalDateTime fecha2) throws BadPeriod {

        //FECHAS NO VALIDAS
        if (fecha2.isAfter(fecha1)) throw new BadPeriod();
        return getList(getLlamadas(cliente),fecha1,fecha2);
    }

    LinkedList<Factura> getFacturas(Cliente cliente, LocalDateTime fecha1, LocalDateTime fecha2) throws BadPeriod {

        //FECHAS NO VALIDAS
        if (fecha2.isAfter(fecha1)) throw new BadPeriod(); //Añadir excepción
        return getList(getFacturas(cliente),fecha1,fecha2);

    }



}
