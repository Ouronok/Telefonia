package modelo;

import modelo.clientes.Cliente;
import modelo.excepciones.NotContained;
import modelo.datos.Factura;

import java.time.LocalDateTime;
import java.util.LinkedList;

public interface CambioModelo {
    Cliente getCliente(String nif) throws NotContained;

    void getClientes();

    void creaEmpresa(String nombre, String nif, String email,  String cp, String provincia, String poblacion);

    void creaParticular(String nombre, String apellidos, String nif, String email,  String cp, String provincia, String poblacion);

    void swpTarifa(int i, Cliente seleccionado);

    void swpPrecio(Cliente cliente, double precio);

    LinkedList<Factura> getFacturas(Cliente seleccionado);

    void emitirFactura(Cliente cliente, LocalDateTime[] intervalo);

    Factura getFactura(int id);

    boolean delFac(int id);
}

