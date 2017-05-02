package vista.ventanas;

import vista.escuchadores.EscPrin;
import vista.escuchadores.Escuchador;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by ouronok on 2/05/17.
 */
public class Principal extends JFrame implements Ventanas {

    Escuchador escuchador;


    private void crea() {
        JButton boton = new JButton("Mostrar");
        boton.addActionListener(escuchador);
        getContentPane().add(boton);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void setListener(Escuchador escuchador) {
        this.escuchador=escuchador;
        crea();

    }

    @Override
    public void setVisible(Boolean stat) {
    setVisible(stat);
    }

    @Override
    public Escuchador getListener() {
        return escuchador;
    }
}
