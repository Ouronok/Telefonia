package vista;

import controlador.Controlador;
import controlador.Manejo;
import modelo.CambioModelo;
import modelo.InterrogaModelo;
import modelo.operaciones.Aplicacion;


public class ImplementacionVista implements InterrogaVista,InformaVista {

    private Controlador controlador;
    private InterrogaModelo modelo;


    public void setControlador(Manejo controlador) {
        this.controlador = controlador;
    }

    public void setModelo(InterrogaModelo modelo) {
        this.modelo = modelo;
    }
}
