package controlador;

import modelo.CambioModelo;
import vista.Escuchador;
import vista.InterrogaVista;


public class Manejo implements Controlador {

    private InterrogaVista vista;
    private CambioModelo modelo;
    private Escuchador escuchador;


    @Override
    public void escribe() {
        System.out.println("Recibido");
    }


    public void setModelo(CambioModelo modelo) {
        this.modelo = modelo;
    }


    public void setVista(InterrogaVista vista) {
        this.vista = vista;
    }

    public void setEscuchador(Escuchador escuchador) {
        this.escuchador = escuchador;
    }
}
