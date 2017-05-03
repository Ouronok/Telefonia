package vista.ventanas;

import vista.escuchadores.EscPrin;
import vista.escuchadores.Escuchador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by ouronok on 2/05/17.
 */
public class Principal extends Ventana {

    public void crea() {
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

}
