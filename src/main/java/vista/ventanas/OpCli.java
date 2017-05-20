package vista.ventanas;

import modelo.InterrogaModelo;
import modelo.clientes.Cliente;
import vista.escuchadores.Escuchador;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.NumberFormat;

/**
 * Created by ouron on 17/05/2017.
 */
public class OpCli extends Ventana {
    private Container contenedor;
    private JLabel cactext;
    private Cliente seleccionado;
    private JTextField cact;
    private JFormattedTextField precio;

    @Override
    public void crea() {
        super.setTitle("Operaciones con clientes");
        super.escuchador = new CliEsc();
        contenedor = getContentPane();
        rellena();
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);





    }


    public void selecciona(Cliente cliente) {
        cactext.setText(cliente.getNombre());
        seleccionado = cliente;
    }


    private void rellena(){
        JLabel act = new JLabel("Elegir cliente: ");
        cact = new JTextField(20);

        JButton busca = new JButton("Seleccionar");
        busca.addActionListener(escuchador);
        JPanel down = new JPanel();
        cactext = new JLabel("Ningun cliente");
        down.add(act);
        down.add(cact);
        down.add(cactext);
        down.add(busca);
        JTabbedPane pestanyas = new JTabbedPane();
        pestanyas.add("Tarifas",new PanelTarifas());
        pestanyas.add("Facturas",new PanelFacturas());
        pestanyas.add("Llamadas",new PanelLlamadas());
        JButton atras = new JButton("Atras");
        atras.addActionListener(escuchador);
        contenedor.add(pestanyas,BorderLayout.CENTER);
        contenedor.add(atras,BorderLayout.SOUTH);
        contenedor.add(down,BorderLayout.NORTH);
    }

    public void noSel() {
        JOptionPane.showMessageDialog(this,"No se ha seleccionado ningun cliente");
    }

    private void noVal() {
        JOptionPane.showMessageDialog(this,"Introduce un entero valido");
    }


    public void exitoTarifa() {
        JOptionPane.showMessageDialog(this,"Tarifa cambiada con exito");
    }
    private class PanelTarifas extends JPanel{




        public PanelTarifas() {
            setLayout(new BorderLayout());
            JPanel down = new JPanel();
            JButton cambiaprecio = new JButton("Cambiar precio");
            cambiaprecio.addActionListener(escuchador);
            JButton basica = new JButton("Basica");
            basica.addActionListener(escuchador);
            JButton tardes = new JButton("Tardes");
            tardes.addActionListener(escuchador);
            JButton domingos = new JButton("Domingos");
            domingos.addActionListener(escuchador);
            JLabel indtar = new JLabel("Cambiar tarifa: ");
            JLabel txtprecio = new JLabel("Nuevo precio tarifa actual: ");

            precio = new JFormattedTextField(15);

            JPanel up = new JPanel();
            up.add(txtprecio);
            up.add(precio);
            up.add(cambiaprecio);
            add(up,BorderLayout.NORTH);
            down.add(indtar);
            down.add(basica);
            down.add(tardes);
            down.add(domingos);
            add(down,BorderLayout.SOUTH);




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
            switch(texto) {
                case ("Atras"):
                    super.controlador.atrasOpCli();
                    break;
                case ("Seleccionar"):
                    super.controlador.seleccionaCliente(cact.getText());
                    break;
                case ("Basica"):
                    if (seleccionado != null) {
                        super.controlador.setBasica(seleccionado);
                    } else {
                        noSel();
                    }
                case ("Tardes"):
                    if (seleccionado != null) {
                        super.controlador.setTardes(seleccionado);
                    } else {
                        noSel();
                    }
                    break;
                case ("Domingos"):
                    if (seleccionado != null) {
                        super.controlador.setDomingos(seleccionado);
                    } else {
                        noSel();
                    }
                    break;
                case("Cambiar precio"):
                    if(seleccionado==null) {
                        noSel();
                        break;
                    }else if(precio.getValue() instanceof Double || precio.getValue() instanceof Integer && (int) precio.getValue()*1.>0){
                        super.controlador.swpPrecio(seleccionado, (int) precio.getValue() * 1.);
                    } else {
                        noVal();
                    }
            }
        }

    }
}

