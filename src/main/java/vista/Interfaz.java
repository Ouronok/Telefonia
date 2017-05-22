package vista;

import controlador.Controlador;
import controlador.Manejo;
import modelo.InterrogaModelo;
import modelo.clientes.Cliente;
import modelo.datos.Factura;
import modelo.datos.Llamada;
import vista.ventanas.Mostrar;
import vista.ventanas.OpCli;
import vista.ventanas.Operaciones;
import vista.ventanas.Principal;

import java.io.Serializable;
import java.util.LinkedList;


public class Interfaz implements InterrogaVista, InformaVista, Serializable {

    private Principal principal;
    private Mostrar mostrar;
    private Operaciones operaciones;

    private OpCli clientes;


    public void setControlador(Manejo controlador) {
        Controlador controlador1 = controlador;
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
        InterrogaModelo modelo1 = modelo;
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

        clientes.selecciona(cliente);
    }

    @Override
    public void noSel() {
        clientes.noSel();
    }

    @Override
    public void noEnc() {
        mostrar.error();
    }

    @Override
    public void mostrarFacturas(LinkedList<Factura> facturas) {
        clientes.mostrarFacturas(facturas);
    }

    @Override
    public void muestraFactura(Factura factura) {
        if (factura == null) {
            clientes.noFac();
        } else {
            clientes.muestraFactura(factura);
        }
    }

    @Override
    public void borraFac(boolean b) {
        clientes.facBorrada(b);
    }

    @Override
    public void borraCliente(Cliente cliente) {
        operaciones.clienteBorrado();
    }

    @Override
    public void mostrarLlamadas(LinkedList<Llamada> llamadas) {
        clientes.mostrarLlamadas(llamadas);

    }


    public void noCli() {
        mostrar.error();
    }

    @Override
    public void getClientes(LinkedList<Cliente> clientes) {
        mostrar.mostrarClientes(clientes);
    }

    @Override
    public void tarifaCambiada() {
        clientes.exitoTarifa();
    }

    @Override
    public void clienteAnyadido() {

        operaciones.exitoAnyadido();
    }

    @Override
    public void clienteNoAnyadido() {

        operaciones.errorAnyadido();
    }


    public void facan() {

    }

    @Override
    public void saveError() {
        principal.saveError();
    }

    @Override
    public void saveSuccesful() {
        principal.saveSuccesful();
    }
}
