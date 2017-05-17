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



    private JTextField dni;

    private JButton muestra;
    private JButton atras;
    private JButton limpia;
    private JList moscli;
    private Container contenedor;
    private JButton dnibut;
    private DefaultListModel<String> model;

    public void crea() {
        super.setTitle("Muestra clientes");
        super.escuchador = new EscMos();
        contenedor = getContentPane();
        rellena();
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }


    public void error() {
        JOptionPane.showMessageDialog(this,"No existe dicho cliente");
    }


    private void rellena() {
        limpia = new JButton("Limpia");
        limpia.addActionListener(super.escuchador);
        JLabel dnie = new JLabel("DNI:");
        dni = new JTextField(8);
        atras = new JButton("Atras");
        atras.addActionListener(super.escuchador);
        dnibut = new JButton("DNI");
        dnibut.addActionListener(super.escuchador);
        muestra = new JButton("Muestra");
        muestra.addActionListener(super.escuchador);
        JPanel upanel = new JPanel();
        upanel.add(dnie);
        upanel.add(dni);
        upanel.add(dnibut);
        upanel.add(muestra);
        contenedor.add(upanel, BorderLayout.NORTH);
        moscli = new JList();
        model = new DefaultListModel<>();
        moscli.setModel(model);
        contenedor.add(moscli, BorderLayout.CENTER);
        JPanel spanel = new JPanel();
        spanel.add(limpia);
        spanel.add(atras);
        contenedor.add(spanel,BorderLayout.SOUTH);
    }

    public void mostrarClientes(LinkedList<Cliente> clientes) {
        limpia();
        for(Cliente cac: clientes){
            model.addElement(cac.toString());
        }
        pack();
    }

    public void muestraCliente(Cliente cliente){
        model.addElement(cliente.toString());
        pack();

    }
    private void limpia() {
        model.removeAllElements();
        pack();

    }



    private class EscMos extends Escuchador {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton boton = (JButton)e.getSource();
            String texto = boton.getText();
            switch(texto){
                case("DNI"):
                    System.out.println("Aqui");
                    super.controlador.buscaCliente(dni.getText());
                    break;
                case("Muestra"):
                    super.controlador.muestraClientes();
                    break;
                case("Atras"):
                    super.controlador.atrasMostrar();
                case("Limpia"):
                    limpia();
            }

        }
    }


}
