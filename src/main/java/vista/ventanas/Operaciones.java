package vista.ventanas;

import modelo.clientes.Cliente;
import vista.escuchadores.Escuchador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class Operaciones extends Ventana {

    private Container contenedor;
    private JButton añadir;
    private JTextField nif;
    private JTextField nombre;
    private JTextField apellidos;
    private JCheckBox empresa;
    private JTextField poblacion;
    private JTextField provincia;
    private JTextField cp;
    private JTextField email;
    private JFormattedTextField precio;

    @Override
    public void crea() {
        super.setTitle("Operaciones disponibles");
        super.escuchador = new EscuchaOperaciones();
        contenedor = getContentPane();
        rellena();
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }


    public void error() {
        JOptionPane.showMessageDialog(this, "Este cliente ya existe");
    }

    private void rellena() {

        JTabbedPane pestanyas = new JTabbedPane();
        añadir = new JButton("Añadir");
        JButton atras = new JButton("Atras");
        atras.addActionListener(super.escuchador);
        pestanyas.add("Añadir Cliente", new PannelAnyadir());
        pestanyas.add("Borrar Cliente", new PannelBorrar());
        contenedor.add(pestanyas, BorderLayout.CENTER);
        JPanel spanel = new JPanel();
        spanel.add(atras);
        contenedor.add(spanel, BorderLayout.SOUTH);
    }


    private class PannelAnyadir extends JPanel {
        private PannelAnyadir() {

            setLayout(new GridLayout(30, 1));

            //FIELDS
            JLabel etiqueta_Nif = new JLabel("NIF: ");
            nif = new JTextField(8);
            JLabel etiqueta_Nombre = new JLabel("Nombre: ");
            nombre = new JTextField(25);
            JLabel etiqueta_Apellido = new JLabel("Apellidos: ");
            apellidos = new JTextField(20);
            JLabel etiqueta_Empresa = new JLabel("Empresa: ");
            empresa = new JCheckBox();
            JLabel etiqueta_Provincia = new JLabel("Provincia: ");
            provincia = new JTextField(40);
            JLabel etiqueta_Poblacion = new JLabel("Poblacion: ");
            poblacion = new JTextField(40);
            JLabel etiqueta_cp = new JLabel("Codigo postal: ");
            cp = new JTextField(40);
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
            add(etiqueta_Provincia);
            add(provincia);
            add(etiqueta_Poblacion);
            add(poblacion);
            add(etiqueta_cp);
            add(cp);
            add(etiqueta_Email);
            add(email);
            add(añadir, BorderLayout.SOUTH);
        }


    }

    private class PannelBorrar extends JPanel {

        private PannelBorrar() {
            //FIELDS
            setLayout(new GridLayout(20, 2));
            JLabel etiqueta_Nif = new JLabel("NIF: ");
            nif = new JTextField(8);

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
                    System.out.println("hola");

                    super.controlador.atrasOp();
                    break;
                case ("Añadir"):

                  if (empresa.isSelected() && (precio.getValue() instanceof Double || precio.getValue() instanceof Integer && (int) precio.getValue() * 1. > 0))
                        super.controlador.addEmpresa(nombre.getText(), nif.getText() , email.getText(), cp.getText(), provincia.getText(), poblacion.getText(), (int) precio.getValue() * 1.);
                    else if (precio.getValue() instanceof Double || precio.getValue() instanceof Integer && (int) precio.getValue() * 1. > 0)
                        super.controlador.addParticular(nombre.getText(), nif.getText() , email.getText(), email.getText(), cp.getText(), provincia.getText(), poblacion.getText()
                                , (int) precio.getValue() * 1.);

            }

        }
    }
}
