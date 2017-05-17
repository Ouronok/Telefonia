package vista;

import controlador.Controlador;
import controlador.Manejo;
import modelo.InterrogaModelo;
import modelo.clientes.Cliente;
import vista.ventanas.Mostrar;
import vista.ventanas.OpCli;
import vista.ventanas.Operaciones;
import vista.ventanas.Principal;

import java.util.LinkedList;


public class Interfaz implements InterrogaVista,InformaVista {

    private Controlador controlador;
    private InterrogaModelo modelo;
    Principal principal;
    Mostrar mostrar;
    Operaciones operaciones;
    OpCli clientes;


    public void setControlador(Manejo controlador) {
        this.controlador = controlador;
        inicializa(controlador);


    }

    private void inicializa(Manejo controlador) {
        principal = new Principal();
        mostrar = new Mostrar();
        clientes = new OpCli();
        principal.getListener().setControlador(controlador);
        principal.setVisible(true);
        mostrar.getListener().setControlador(controlador);
        operaciones = new Operaciones();
        operaciones.getListener().setControlador(controlador);
        clientes.getListener().setControlador(controlador);

    }

    public void setModelo(InterrogaModelo modelo) {
        this.modelo = modelo;
    }

    @Override
    public void abreMostrar() {
        principal.setVisible(false);
        mostrar.setVisible(true);

    }

    @Override
    public void cierraMostrar() {
        principal.setVisible(true);
        mostrar.setVisible(false);

    }

    @Override
    public void abreOps() {
        principal.setVisible(false);
        operaciones.setVisible(true);
    }

    @Override
    public void abreCliente() {
        principal.setVisible(false);
        clientes.setVisible(true);
    }

    @Override
    public void cierraOpCli() {
        clientes.setVisible(false);
        principal.setVisible(true);
    }

    @Override
    public void cierraOp() {
        operaciones.setVisible(false);
        principal.setVisible(true);
    }

    @Override
    public void muestraCliente(Cliente cliente
    ) {
        mostrar.muestraCliente(cliente);
    }

    @Override
    public void selecciona(Cliente cliente) {
        operaciones.selecciona(cliente);
    }

    @Override
    public void noCli() {
        mostrar.error();
    }

    @Override
    public void getClientes(LinkedList<Cliente> clientes) {
        mostrar.mostrarClientes(clientes);
    }

}
