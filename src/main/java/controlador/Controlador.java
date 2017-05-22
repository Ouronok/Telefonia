package controlador;

import modelo.clientes.Cliente;

import java.time.LocalDateTime;

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

    void addEmpresa(String nif , String nombre , String email, String cp, String provincia, String poblacion);

    void addParticular(String nif, String nombre, String apellidos  , String email, String cp, String provincia, String poblacion);

    void delCliente(String nif );

    void setBasica(Cliente seleccionado);

    void setTardes(Cliente seleccionado);

    void setDomingos(Cliente seleccionado);

    void swpPrecio(Cliente seleccionado, double valor);

    void listFac(Cliente seleccionado);

    void listLlam(Cliente seleccionado);

    void addFac(Cliente seleccionado, LocalDateTime now);

    void addLLam(Cliente seleccionado, String tlf, int duracion);

    void borraFac(int id);

    void buscaFac(int id);

    void save();
}
