package modelo;

import modelo.clientes.Cliente;
import modelo.datos.Llamada;
import modelo.excepciones.NotContained;
import modelo.datos.Factura;

import java.time.LocalDateTime;
import java.util.LinkedList;

public interface CambioModelo {

    Cliente getCliente(String nif) throws NotContained;

    void getClientes();

    void creaEmpresa(String nif, String nombre, String email, String cp, String provincia, String poblacion);

    void creaParticular(String nif, String nombre, String apellidos, String email, String cp, String provincia, String poblacion);

    void swpTarifa(int i, Cliente seleccionado);

    void swpPrecio(Cliente cliente, double precio);

    LinkedList<Factura> getFacturas(Cliente seleccionado);

    void emitirFactura(Cliente cliente, LocalDateTime[] intervalo);

    Factura getFactura(int id);

    boolean delFac(int id);

    Cliente delCliente(String nif) throws NotContained;

    LinkedList<Llamada> getLlamadas(Cliente seleccionado);

    void emitirLlamada(Cliente seleccionado, String tlf, int duracion, LocalDateTime fecha);

    void save();
}
