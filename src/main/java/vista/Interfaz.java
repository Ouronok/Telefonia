package vista;

import controlador.Controlador;
import controlador.Manejo;
import modelo.InterrogaModelo;

import javax.swing.*;


public class Interfaz implements InterrogaVista,InformaVista {

    private Controlador controlador;
    private InterrogaModelo modelo;

    public Interfaz(){
        inicializa();
    }

    private void inicializa() {
        Escuchador escuchador = new Escuchador();
        escuchador.setControlador(controlador);
        JFrame principal = new JFrame();
        JButton boton = new JButton("Pulsame para informar");
        boton.addActionListener(escuchador);
        principal.getContentPane().add(boton);
        principal.pack();
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        principal.setVisible(true);
    }


    public void setControlador(Manejo controlador) {
        this.controlador = controlador;
    }

    public void setModelo(InterrogaModelo modelo) {
        this.modelo = modelo;
    }
}
