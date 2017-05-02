package vista;

import controlador.Controlador;
import controlador.Manejo;
import modelo.InterrogaModelo;
import vista.escuchadores.EscPrin;
import vista.ventanas.Principal;

import javax.swing.*;


public class Interfaz implements InterrogaVista,InformaVista {

    private Controlador controlador;
    private InterrogaModelo modelo;
    Principal principal= new Principal();








    public void setControlador(Manejo controlador) {
        this.controlador = controlador;
        inicializa(controlador);


    }

    private void inicializa(Manejo controlador) {
        principal.setListener(new EscPrin());
        principal.getListener().setControlador(controlador);
        principal.setVisible(true);
    }

    public void setModelo(InterrogaModelo modelo) {
        this.modelo = modelo;
    }
}
