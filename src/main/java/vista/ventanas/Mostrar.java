package vista.ventanas;

import modelo.clientes.Cliente;
import vista.escuchadores.Escuchador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;


public class Mostrar extends Ventana {



    private JTextField dni;
    private Container contenedor;
    private DefaultListModel<String> model;



    public void crea() {
        super.setTitle("Muestra clientes");
        super.escuchador = new EscMos();
        contenedor = getContentPane();
        rellena();
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }


    public void error() {
        JOptionPane.showMessageDialog(this,"No existe dicho cliente");
    }


    private void rellena() {

        JButton limpia = new JButton("Limpia");
        limpia.addActionListener(super.escuchador);
        JLabel dnie = new JLabel("DNI:");
        dni = new JTextField(8);
        JButton atras = new JButton("Atras");
        atras.addActionListener(super.escuchador);
        JButton dnibut = new JButton("DNI");
        dnibut.addActionListener(super.escuchador);
        JButton muestra = new JButton("Muestra");
        muestra.addActionListener(super.escuchador);
        JPanel upanel = new JPanel();
        upanel.add(dnie);
        upanel.add(dni);
        upanel.add(dnibut);
        upanel.add(muestra);
        contenedor.add(upanel, BorderLayout.NORTH);
        JList moscli = new JList();
        model = new DefaultListModel<>();
        moscli.setModel(model);
        JScrollPane barra = new JScrollPane(moscli);
        contenedor.add(barra, BorderLayout.CENTER);
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
        limpia();
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
