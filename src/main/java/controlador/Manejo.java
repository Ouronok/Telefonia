package controlador;

import modelo.CambioModelo;
import modelo.clientes.Cliente;
import modelo.excepciones.NotContained;
import vista.InterrogaVista;


public class Manejo implements Controlador {

    private InterrogaVista vista;
    private CambioModelo modelo;


    public void setModelo(CambioModelo modelo) {
        this.modelo = modelo;
    }


    public void setVista(InterrogaVista vista) {
        this.vista = vista;
    }

    public void abreMostrar() {
        vista.abreMostrar();
    }

    @Override
    public void buscaCliente(String dni) {
        try {
            vista.muestraCliente(modelo.getCliente(dni));
        } catch (NotContained notContained) {
            vista.noEnc();
        }

    }

    @Override
    public void muestraClientes() {
        modelo.getClientes();
    }

    @Override
    public void atrasMostrar() {
        vista.cierraMostrar();
    }

    @Override
    public void abreOps() {
        vista.abreOps();
    }

    @Override
    public void abreCliente() {
        vista.abreCliente();
    }

    @Override
    public void atrasOpCli() {
        vista.cierraOpCli();
    }

    @Override
    public void atrasOp() {
        vista.cierraOp();
    }

    @Override
    public void seleccionaCliente(String text) {
        try {
            vista.selecciona(modelo.getCliente(text));
        } catch (NotContained notContained) {
            vista.noSel();
        }
    }

    @Override
    public void addEmpresa(String nombre, String nif, String email, String[] dir, Double precio) {
    }

    @Override
    public void addParticular(String nombre, String nif, String apellidos, String[] dir, Double precio) {

    }

    @Override
    public void setBasica(Cliente seleccionado) {
        modelo.swpTarifa(3,seleccionado);
    }

    @Override
    public void setTardes(Cliente seleccionado) {
        modelo.swpTarifa(2,seleccionado);

    }

    @Override
    public void setDomingos(Cliente seleccionado) {
        modelo.swpTarifa(1,seleccionado);
    }

    @Override
    public void swpPrecio(Object value) {

    }
}
