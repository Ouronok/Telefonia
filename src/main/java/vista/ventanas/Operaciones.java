package vista.ventanas;

import vista.escuchadores.Escuchador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class Operaciones extends Ventana {

    private JButton atras;
    private Container contenedor;

    @Override
    public void crea() {
        super.setTitle("Operaciones disponibles");
        super.escuchador = new EscuchaOperaciones();
        contenedor = getContentPane();
        rellena();
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }

    private void rellena() {

        JTabbedPane pestanyas = new JTabbedPane();
        atras = new JButton("Atras");
        atras.addActionListener(super.escuchador);
        pestanyas.add("Añadir Cliente", new PannelAnyadir());
        pestanyas.add("Borrar Cliente", new PannelBorrar());
        contenedor.add(pestanyas);
        JPanel spanel = new JPanel();
        spanel.add(atras);
        contenedor.add(spanel, BorderLayout.SOUTH);
    }


    private class PannelAnyadir extends JPanel {
        public PannelAnyadir() {

            setLayout(new GridLayout(10, 2));

            //FIELDS
            JLabel etiqueta_Nif = new JLabel("NIF: ");
            JTextField nif = new JTextField(8);
            JLabel etiqueta_Nombre = new JLabel("Nombre: ");
            JTextField nombre = new JTextField(25);
            JLabel etiqueta_Apellido = new JLabel("Apellidos: ");
            JTextField apellidos = new JTextField(20);
            JLabel etiqueta_Empresa = new JLabel("Empresa: ");
            JCheckBox empresa = new JCheckBox();
            JLabel etiqueta_Direccion = new JLabel("Direccion: ");
            JTextField direccion = new JTextField(30);
            JLabel etiqueta_Email = new JLabel("Email: ");
            JTextField email = new JTextField(20);

            //AÑADE EN EL PANEL
            add(etiqueta_Nif);
            add(nif);
            add(etiqueta_Nombre);
            add(nombre);
            add(etiqueta_Apellido);
            add(apellidos);
            add(etiqueta_Empresa);
            add(empresa);
            add(etiqueta_Direccion);
            add(direccion);
            add(etiqueta_Email);
            add(email);
        }


    }

    private class PannelBorrar extends JPanel {

        public PannelBorrar() {
            setLayout(new GridLayout(20, 2));
            JLabel etiqueta_Nif = new JLabel("NIF: ");
            JTextField nif = new JTextField(8);

            //AÑADE EN EL PANEL
            add(etiqueta_Nif);
            add(nif);

        }

    }

    private class EscuchaOperaciones extends Escuchador {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton boton = (JButton) e.getSource();
            String texto = boton.getText();
            switch (texto) {
                case ("Atras"):
                    super.controlador.atrasOp();
            }

        }
    }
}
