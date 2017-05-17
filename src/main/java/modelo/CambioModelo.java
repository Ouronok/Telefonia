package modelo;

import modelo.clientes.Cliente;

public interface CambioModelo {
    Cliente getCliente(String nif);

    void getClientes();

    void creaEmpresa(String nombre, String nif, String email, String[] dir, Double precio);

    void creaParticular(String nombre, String apellidos, String nif, String email, String[] dir, Double precio);
}

