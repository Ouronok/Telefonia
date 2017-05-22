package vista.ventanas;

import modelo.clientes.Cliente;
import vista.escuchadores.Escuchador;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by ouronok on 2/05/17.
 */
public class  Principal extends Ventana {

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
        JButton guarda = new JButton("Guardar");
        guarda.addActionListener(escuchador);
        boton1.addActionListener(escuchador);
        boton2.addActionListener(escuchador);
        boton3.addActionListener(escuchador);
        panel.setLayout(new BorderLayout());
        JPanel up = new JPanel();
        up.add(boton1);
        up.add(boton2);
        up.add(boton3);
        panel.add(up,BorderLayout.NORTH);
        JPanel down = new JPanel();
        down.add(guarda);
        panel.add(down,BorderLayout.SOUTH);
    }

    public void saveSuccesful() {
        JOptionPane.showMessageDialog(this, "Guardado con exito");
    }

    public void saveError() {
        JOptionPane.showMessageDialog(this, "Error al guardar");
    }

    public void noLoaded() {
        JOptionPane.showMessageDialog(this, "El programa se ha iniciado por primera vez");
    }

    public void loaded() {
        JOptionPane.showMessageDialog(this, "Se ha cargado con exito");
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
                    break;
                case("Guardar"):
                    super.controlador.save();
            }
        }
    }
}
