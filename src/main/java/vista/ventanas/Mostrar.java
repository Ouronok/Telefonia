package vista.ventanas;

import vista.escuchadores.Escuchador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by ouronok on 2/05/17.
 */
public class Mostrar extends Ventana {


    private JTextField nombre;
    private JTextField dni;
    private JTextField ape;

    public void crea() {
        super.escuchador= new EscMos();
        Container contenedor = getContentPane();
        JPanel panel = new JPanel();
        boxes(contenedor);
        JPanel panel2 = new JPanel();
        botones(panel2);
        contenedor.add(panel2);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }


    public void error() {
        JOptionPane.showMessageDialog(this,"No se puede completar la busqueda");
    }

    private void botones(JPanel panel2) {
    }

    private void boxes(Container contenedor) {
        nombre = new JTextField(25);
        dni = new JTextField(8);
        ape = new JTextField(20);
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


    private class EscMos extends Escuchador {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton boton = (JButton)e.getSource();
            String texto = boton.getText();
            switch(texto){
                case("Buscar"):
                    String search = dni.getText();
                    super.controlador.buscaCliente(search);
                    break;
            }

        }
    }
}
