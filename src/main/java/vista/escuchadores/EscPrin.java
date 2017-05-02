package vista.escuchadores;

import controlador.Controlador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EscPrin extends Escuchador {

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton)e.getSource();
        String texto = boton.getText();
        switch(texto){
            case("Mostrar"):
                super.controlador.abreMostrar();
                break;
            }
        }
}


