package principal;

import javax.swing.*;

/**
 * Created by ouron on 01/05/2017.
 */
public class Ventana extends JFrame {
    public Ventana(){
        super("Principal");
    }

    public void ejecuta() {
        setSize(500,500);
        setVisible(true);
        JFrame ventana = new JFrame("Principal");
        JButton boton = new JButton("Pulsame");
        getContentPane().add(boton);
        boton.addActionListener(new Escuchador());
    }
}
