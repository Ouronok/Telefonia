package vista.ventanas;

import modelo.clientes.Cliente;
import vista.escuchadores.Escuchador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

/**
 * Created by ouronok on 2/05/17.
 */
public class Mostrar extends Ventana {


    private JTextField nombre;
    private JTextField dni;
    private JTextField ape;
    private JButton muestra;
    private JList moscli;
    private Container contenedor;

    public void crea() {
        super.escuchador= new EscMos();
        contenedor = getContentPane();
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
        muestra = new JButton("Muestra");
        muestra.addActionListener(super.escuchador);
        JLabel enombre = new JLabel("Nombre");
        JLabel eap = new JLabel("Apellidos");
        JLabel edni = new JLabel("DNI:");
        contenedor.setLayout(new FlowLayout());
        JPanel upanel = new JPanel();

        String[] mosclit = {"Hola","Pepe"};
        moscli = new JList(mosclit);
        upanel.add(edni);
        upanel.add(dni);
        upanel.add(eap);
        upanel.add(ape);
        upanel.add(enombre);
        upanel.add(nombre);
        upanel.add(muestra);
        contenedor.add(upanel, BorderLayout.NORTH);

        getContentPane().add(moscli, BorderLayout.SOUTH);

    }

    public void mostrarClientes(Cliente[] clientes) {
        String[] mosclit = {"Hola","Pepe"};
        moscli = new JList(mosclit);
        getContentPane().add(moscli);
        revalidate();
        repaint();
        System.out.println("Holas");

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
                case("Muestra"):
                    super.controlador.muestraClientes();
            }

        }
    }
}
