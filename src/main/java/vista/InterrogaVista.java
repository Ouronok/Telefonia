package vista;

import modelo.clientes.Cliente;
import modelo.datos.Factura;

import java.util.LinkedList;

/**
 * Created by ouronok on 25/04/17.
 */
public interface InterrogaVista {
    void abreMostrar();

    void cierraMostrar();

    void abreOps();

    void abreCliente();

    void cierraOpCli();

    void cierraOp();

    void muestraCliente(Cliente cliente);

    void selecciona(Cliente cliente);

  /*  boolean creaParticular();
    boolean creaEmpresa();
    boolean addCliente();
    boolean delCliente();
    boolean crearDir();
    boolean swpPrecio();
    Cliente getCliente();
    LinkedList getClientes();
    boolean emitirFactura();
    double calcImp();
    Factura getFatura();
    LinkedList getList();
    boolean swpTarifa();

*/
}
