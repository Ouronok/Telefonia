import java.util.LinkedList;

/**
 * Created by al342052 on 21/02/2017.
 */
public class Aplicacion {
    LinkedList<Cliente> clientes;

    public boolean addCliente(Cliente cliente) {
        if (!clientes.contains(cliente)) {
            clientes.add(cliente);
            return true;
        }
        return false;
    }
    public boolean delCliente(Cliente cliente) {
        if (clientes.contains(cliente)){
            clientes.remove(cliente);
            return true;
        }
        return false;
    }
    public boolean swpTarifa(Cliente cliente, Tarifa tarifa) {
        if(clientes.contains(cliente)){
            cliente.swpTarifa(tarifa);
            return true;
        }
        return false;
    }


}
