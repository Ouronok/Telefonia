package vista.ventanas;

import vista.escuchadores.Escuchador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by ouronok on 2/05/17.
 */
public class Principal extends Ventana {

    public void crea() {
        super.setTitle("Menu principal");
        super.escuchador = new EscPrin();
        Container contenedor = getContentPane();
        JPanel panel = new JPanel();
        botones(panel);
        contenedor.add(panel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void botones(JPanel panel) {
        JButton boton1 = new JButton("Mostrar");
        JButton boton2 = new JButton("Operaciones");
        JButton boton3 = new JButton("Cliente");
        boton1.addActionListener(escuchador);
        boton2.addActionListener(escuchador);
        boton3.addActionListener(escuchador);
        panel.add(boton1);
        panel.add(boton2);
        panel.add(boton3);
    }

    private class EscPrin extends Escuchador {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton boton = (JButton) e.getSource();
            String texto = boton.getText();
            switch (texto) {
                case ("Mostrar"):
                    super.controlador.abreMostrar();
                    break;
                case ("Operaciones"):
                    super.controlador.abreOps();
                    break;
                case ("Cliente"):
                    super.controlador.abreCliente();
            }
        }
    }
}
