package modelo;

import modelo.clientes.Cliente;
import modelo.datos.Factura;

import java.util.LinkedList;

public interface Modelo {
    boolean creaParticular();
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
}
