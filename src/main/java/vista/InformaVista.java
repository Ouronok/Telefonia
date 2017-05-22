package vista;

import modelo.clientes.Cliente;

import java.util.LinkedList;



public interface InformaVista {

    void noCli();

    void getClientes(LinkedList<Cliente> clientes);

    void tarifaCambiada();

    void clienteAnyadido();

    void clienteNoAnyadido();

    void facan();

    void saveError();

    void saveSuccesful();

}
