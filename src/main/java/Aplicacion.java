import java.time.LocalDateTime;
import java.util.LinkedList;

/**
 * Created by al342052 on 21/02/2017.
 */
class Aplicacion {
    private LinkedList<Cliente> clientes = new LinkedList<>();
    private final LocalDateTime fact = LocalDateTime.now();

    boolean addCliente(String nombre, String nif, Direccion dir, Double precio) {
        Tarifa tarifa = new Tarifa(precio);
        Empresa cliente = new Empresa(nombre, nif, dir, fact, tarifa);
        return addCliente(cliente);
    }

    boolean addCliente(String nombre, String apellidos, String nif, Direccion dir, Double precio) {
        Tarifa tarifa = new Tarifa(precio);
        Particular cliente = new Particular(nombre, apellidos, nif, dir, fact, tarifa);
        return addCliente(cliente);
    }

    boolean addCliente(Cliente cliente) {
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

    Cliente getCliente(String nif) {
        for (Cliente cAct : clientes) {
            if (cAct.getNif().equals(nif)) {
                return cAct;
            }
        }
        return null;
    }

    LinkedList<Cliente> getClientes() {
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

    boolean emitirFactura(Cliente cliente, LocalDateTime[] intervalo) {
        if (!clientes.contains(cliente) || intervalo[0].isAfter(intervalo[2])) {
            return false;
        }
        LinkedList<Llamada> llamadas = cliente.getLlamadaPeriodo(intervalo);
        cliente.addFactura(new Factura(fact, intervalo[0], intervalo[1], cliente, cliente.getTarifa()));
        return true;
    }

    public Factura getFactura(int cod) {
        for (Cliente cliac : clientes) {
            for (Factura faac : cliac.getListafac()) {
                if (faac.getFID() == cod) {
                    return faac;
                }
            }
        }
        return null;
    }

    public LinkedList<Factura> getFacturas(Cliente cliente) {
        return cliente.getListafac();
    }

    public LocalDateTime getTime() {
        return fact;
    }
}
