package vista.ventanas;

import vista.escuchadores.Escuchador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class Operaciones extends Ventana {

    private Container contenedor;
    private JTextField nif1;
    private JTextField nif2;
    private JTextField nombre;
    private JTextField apellidos;
    private JCheckBox empresa;
    private JTextField poblacion;
    private JTextField provincia;
    private JTextField cp;
    private JTextField email;

    @Override
    public void crea() {
        super.setTitle("Operaciones disponibles");
        super.escuchador = new EscuchaOperaciones();
        contenedor = getContentPane();
        rellena();
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }

    public void exitoAnyadido() {
        JOptionPane.showMessageDialog(this, "Cliente añadido con exito");
    }

    public void errorAnyadido() {
        JOptionPane.showMessageDialog(this, "Este cliente ya existe");
    }

    public void clienteBorrado() {
        JOptionPane.showMessageDialog(this, "El cliente ha sido borrado");
    }

    private void noSel() {
        JOptionPane.showMessageDialog(this, "Introduce un NIF");
    }


    private void rellena() {

        JTabbedPane pestanyas = new JTabbedPane();
        JButton atras = new JButton("Atras");
        atras.addActionListener(escuchador);
        pestanyas.add("Añadir Cliente", new PannelAnyadir());
        pestanyas.add("Borrar Cliente", new PannelBorrar());
        contenedor.add(pestanyas, BorderLayout.CENTER);
        JPanel spanel = new JPanel();
        spanel.add(atras);
        contenedor.add(spanel, BorderLayout.SOUTH);
    }


    private class PannelAnyadir extends JPanel {
        PannelAnyadir() {

            setLayout(new GridLayout(30, 1));

            //FIELDS
            JLabel etiqueta_Nif = new JLabel("NIF: ");
            nif1 = new JTextField(8);
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
            email = new JTextField(20);
            JButton añadir = new JButton("Añadir");
            añadir.addActionListener(escuchador);


            //AÑADE EN EL PANEL
            add(etiqueta_Nif);
            add(nif1);
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
            add(añadir);


        }


    }

    private class PannelBorrar extends JPanel {

        private PannelBorrar() {
            //FIELDS
            setLayout(new GridLayout(20, 2));
            JLabel etiqueta_Nif = new JLabel("NIF: ");
            nif2 = new JTextField(8);

            //AÑADE EN EL PANEL

            JButton borrar = new JButton("Borrar");
            borrar.addActionListener(escuchador);
            add(etiqueta_Nif);
            add(nif2);
            add(borrar);
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
                    break;
                case ("Añadir"):

                    if (nif1.getText().equals(""))
                        noSel();

                    else if (empresa.isSelected())
                        super.controlador.addEmpresa(nif1.getText(), nombre.getText(), email.getText(), cp.getText(), provincia.getText(), poblacion.getText());
                    else
                        super.controlador.addParticular(nif1.getText(), nombre.getText(), apellidos.getText(), email.getText(), cp.getText(), provincia.getText(), poblacion.getText());

                    break;
                case ("Borrar"):
                    super.controlador.delCliente(nif2.getText());


            }
        }
    }
}



