package vista;

import controlador.Controlador;
import controlador.Manejo;
import modelo.InterrogaModelo;
import vista.escuchadores.EscMos;
import vista.escuchadores.EscPrin;
import vista.ventanas.Mostrar;
import vista.ventanas.Principal;

import javax.swing.*;


public class Interfaz implements InterrogaVista,InformaVista {

    private Controlador controlador;
    private InterrogaModelo modelo;
    Principal principal= new Principal();
    Mostrar mostrar = new Mostrar();


    public void setControlador(Manejo controlador) {
        this.controlador = controlador;
        inicializa(controlador);


    }

    private void inicializa(Manejo controlador) {
        principal.setListener(new EscPrin());
        principal.getListener().setControlador(controlador);
        principal.setVisible(true);
        mostrar.setListener(new EscMos());
        mostrar.getListener().setControlador(controlador);
    }

    public void setModelo(InterrogaModelo modelo) {
        this.modelo = modelo;
    }

    @Override
    public void abreMostrar() {
        principal.setVisible(false);
        mostrar.setVisible(true);

    }
}
