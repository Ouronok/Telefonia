package modelo;

import modelo.clientes.Cliente;
import modelo.excepciones.NotContained;

public interface CambioModelo {
    Cliente getCliente(String nif) throws NotContained;

    void getClientes();

    void creaEmpresa(String nombre, String nif, String email, String[] dir, Double precio);

    void creaParticular(String nombre, String apellidos, String nif, String email, String[] dir, Double precio);

    void swpTarifa(int i, Cliente seleccionado);

    void swpPrecio(Cliente cliente, double precio);
}

