package vista;

import controlador.Controlador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Escuchador implements ActionListener {
    private Controlador controlador;


    @Override
    public void actionPerformed(ActionEvent e) {
        controlador.escribe();
    }

    public void setControlador(Controlador controlador){
        this.controlador=controlador;
    }
}

