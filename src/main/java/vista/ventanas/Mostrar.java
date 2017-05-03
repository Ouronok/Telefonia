package vista.ventanas;

import vista.escuchadores.EscMos;
import vista.escuchadores.Escuchador;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ouronok on 2/05/17.
 */
public class Mostrar extends Ventana {


    public void crea() {
        Container contenedor = getContentPane();
        JPanel panel = new JPanel();
        boxes(contenedor);
        JPanel panel2 = new JPanel();
        botones(panel2);
        contenedor.add(panel2);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private void botones(JPanel panel2) {
    }

    private void boxes(Container contenedor) {
        JTextField nombre = new JTextField(25);
        JTextField dni = new JTextField(8);
        JTextField ape = new JTextField(20);
        JLabel enombre = new JLabel("Nombre");
        JLabel eap = new JLabel("Apellidos");
        JLabel edni = new JLabel("DNI:");
        contenedor.setLayout(new FlowLayout());

        contenedor.add(edni);
        contenedor.add(dni);
        contenedor.add(eap);
        contenedor.add(ape);
        contenedor.add(enombre);
        contenedor.add(nombre);

    }

}
