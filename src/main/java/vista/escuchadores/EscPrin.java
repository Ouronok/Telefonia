package vista.escuchadores;

import controlador.Controlador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EscPrin extends Escuchador implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        super.controlador.escribe();
    }
}

