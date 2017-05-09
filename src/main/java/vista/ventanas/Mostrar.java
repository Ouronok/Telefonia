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
    private JList moscli;
    private Container contenedor;
    private JButton dnibut;

    public void crea() {
        super.setTitle("Muestra clientes");
        super.escuchador = new EscMos();
        contenedor = getContentPane();
        rellena();
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }


    public void error() {
        JOptionPane.showMessageDialog(this,"No se puede completar la busqueda");
    }


    private void rellena() {
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
        contenedor.add(moscli, BorderLayout.CENTER);
        contenedor.add(atras,BorderLayout.SOUTH);


    }

    public void mostrarClientes(LinkedList<Cliente> clientes) {
        DefaultListModel<Cliente> model = new DefaultListModel<>();
        for(Cliente cac: clientes){
            model.addElement(cac);
        }
        moscli.setModel(model);
        pack();
        System.out.println("Holas");

    }

    public void muestraCliente(Cliente cliente){
        moscli = new JList(new String[]{cliente.toString()});
        System.out.println("Pitos");

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
                    super.controlador.goPrincipal();
            }

        }
    }
}
