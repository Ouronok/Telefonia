package controlador;

import modelo.CambioModelo;
import vista.Escuchador;
import vista.InterrogaVista;


public class Manejo implements Controlador {

    private InterrogaVista vista;
    private CambioModelo modelo;



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



}
