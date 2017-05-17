package controlador;

import modelo.CambioModelo;
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

    public void abreMostrar(){
        vista.abreMostrar();
    }

    @Override
    public void buscaCliente(String dni) {
            modelo.getCliente(dni);
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


}
