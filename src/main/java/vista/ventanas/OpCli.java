package vista.ventanas;

import vista.escuchadores.Escuchador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by ouron on 17/05/2017.
 */
public class OpCli extends Ventana {
    private Container contenedor;

    @Override
    public void crea() {
        super.setTitle("Operaciones con clientes");
        super.escuchador = new CliEsc();
        contenedor = getContentPane();
        rellena();
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);





    }

    private void rellena(){
        JTabbedPane pestanyas = new JTabbedPane();
        pestanyas.add("Tarifas",new PanelTarifas());
        pestanyas.add("Facturas",new PanelFacturas());
        pestanyas.add("Llamadas",new PanelLlamadas());
        JButton atras = new JButton("Atras");
        atras.addActionListener(escuchador);
        contenedor.add(pestanyas,BorderLayout.NORTH);
        contenedor.add(atras,BorderLayout.SOUTH);
    }


    private class PanelTarifas extends JPanel{
        public PanelTarifas() {
            setLayout(new GridLayout(20,2));
            JLabel etiqueta_Nif = new JLabel("NIF: ");
            JTextField nif = new JTextField(8);
            JLabel etiqueta_nombre = new JLabel("Nombre: ");
            JTextField nombre = new JTextField(25);

            JTextField apellidos = new JTextField(20);
            JCheckBox empresa = new JCheckBox();
            JTextField direccion = new JTextField(30);
            JTextField email = new JTextField(20);
            add(etiqueta_Nif);
            add(nif);
            add(etiqueta_nombre);
            add(nombre);
            add(apellidos);
            add(empresa);
            add(direccion);
            add(email);


        }




    }

    private class PanelFacturas extends JPanel{

    }

    private class PanelLlamadas extends JPanel {

    }



    private class CliEsc extends Escuchador {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton boton = (JButton) e.getSource();
            String texto = boton.getText();
            switch(texto){
                case("Atras"):
                    super.controlador.atrasOpCli();
            }

        }
    }
}

