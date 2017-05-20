package controlador;

import modelo.clientes.Cliente;

/**
 * Created by ouron on 01/05/2017.
 */
public interface Controlador {

    void abreMostrar();

    void buscaCliente(String dni);

    void muestraClientes();

    void atrasMostrar();

    void abreOps();

    void abreCliente();

    void atrasOpCli();

    void atrasOp();

    void seleccionaCliente(String text);

    void addEmpresa(String nombre, String nif, String email, String[] dir, Double precio);

    void addParticular(String nombre, String nif, String apellidos, String[] dir , Double precio);

    void setBasica(Cliente seleccionado);

    void setTardes(Cliente seleccionado);

    void setDomingos(Cliente seleccionado);

    void swpPrecio(Cliente seleccionado, double valor);

    void listFac(Cliente seleccionado);
}
