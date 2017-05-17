package modelo;

import modelo.clientes.Cliente;

public interface CambioModelo {
    Cliente getCliente(String nif);
    void getClientes();
}

