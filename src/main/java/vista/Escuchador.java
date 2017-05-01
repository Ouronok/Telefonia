package vista;

import controlador.Controlador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Escuchador implements ActionListener {
    private Controlador controlador;

    public Escuchador(Controlador controlador) {
        this.controlador = controlador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();
        String texto = boton.getText();
        if (texto.equals("Prueba")){
            controlador.escribe();
        }
    }
}
