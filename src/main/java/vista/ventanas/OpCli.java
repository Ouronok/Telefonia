package vista.ventanas;

import modelo.clientes.Cliente;
import modelo.datos.Factura;
import modelo.datos.Llamada;
import vista.escuchadores.Escuchador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;
import java.util.LinkedList;

import static java.lang.Integer.parseInt;

/**
 * Created by ouron on 17/05/2017.
 */
public class OpCli extends Ventana {
    private Container contenedor;
    private JLabel cactext;
    private Cliente seleccionado;
    private JTextField cact;
    private JFormattedTextField precio;
    private DefaultListModel fac;
    private DefaultListModel llam;
    private JTextField idfac;
    private JTextField tlf;
    private JFormattedTextField duracion;


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


    private void rellena() {
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

        pestanyas.add("Tarifas", new PanelTarifas());
        pestanyas.add("Facturas", new PanelFacturas());
        pestanyas.add("Llamadas", new PanelLlamadas());
        JButton atras = new JButton("Atras");
        atras.addActionListener(escuchador);
        contenedor.add(pestanyas, BorderLayout.CENTER);
        contenedor.add(atras, BorderLayout.SOUTH);
        contenedor.add(down, BorderLayout.NORTH);
    }

    public void noSel() {
        JOptionPane.showMessageDialog(this, "No se ha seleccionado ningun cliente");
    }

    private void invalidID() {
        JOptionPane.showMessageDialog(this, "Escribe un id valido");
    }


    private void noVal() {
        JOptionPane.showMessageDialog(this, "Introduce un entero valido");
    }

    public void exitoTarifa() {
        JOptionPane.showMessageDialog(this, "Tarifa cambiada con exito");
    }

    public void mostrarFacturas(LinkedList<Factura> facturas) {
        fac.removeAllElements();
        for (Factura facA : facturas) {
            fac.addElement(facA);
        }
    }

    public void facan() {
        JOptionPane.showMessageDialog(this, "Factura añadida con exito");
    }

    public void noFac() {
        JOptionPane.showMessageDialog(this, "No existe dicha factura");
    }

    public void muestraFactura(Factura factura) {
        fac.addElement(factura);
    }

    public void facBorrada(boolean b) {
        if (b) {
            JOptionPane.showMessageDialog(this, "Factura borrada con exito");
        } else {
            JOptionPane.showMessageDialog(this, "No se ha podido borrar la factura");
        }
    }

    public void mostrarLlamadas(LinkedList<Llamada> llamadas) {
        llam.removeAllElements();
        for (Llamada llamA : llamadas) {
            llam.addElement(llamA);
        }
    }


    private class PanelTarifas extends JPanel {

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
            add(up, BorderLayout.NORTH);
            down.add(indtar);
            down.add(basica);
            down.add(tardes);
            down.add(domingos);
            add(down, BorderLayout.CENTER);


        }

    }

    private class PanelFacturas extends JPanel {
        public PanelFacturas() {
            setLayout(new BorderLayout());
            JPanel up = new JPanel();
            idfac = new JTextField(3);
            JLabel idtxt = new JLabel("ID factura: ");
            JButton busfac = new JButton("Buscar factura");
            busfac.addActionListener(escuchador);
            JButton delfac = new JButton("Borra factura");
            delfac.addActionListener(escuchador);
            JButton adfac = new JButton("Añadir factura");
            adfac.addActionListener(escuchador);
            JButton tofac = new JButton("Mostrar facturas");
            tofac.addActionListener(escuchador);
            up.add(idtxt);
            up.add(idfac);
            up.add(busfac);
            up.add(delfac);
            up.add(tofac);
            up.add(adfac);
            add(up, BorderLayout.NORTH);
            JList mosfac = new JList();
            fac = new DefaultListModel();
            mosfac.setModel(fac);
            JScrollPane barra = new JScrollPane(mosfac);
            barra.setSize(100, 50);
            add(barra, BorderLayout.CENTER);
        }

    }


    private class PanelLlamadas extends JPanel {
        public PanelLlamadas() {
            setLayout(new BorderLayout());
            JPanel up = new JPanel();

            JButton añadirLLam = new JButton("Añadir llamadas");
            añadirLLam.addActionListener(escuchador);
            JButton mostrarLlam = new JButton("Mostrar llamadas");
            mostrarLlam.addActionListener(escuchador);
            JLabel etiqueta_Tlf = new JLabel("Tlf: ");
            tlf = new JTextField(9);
            JLabel etiqueta_Dur = new JLabel("Duración: ");
            duracion = new JFormattedTextField(9);
            up.add(mostrarLlam);
            up.add(añadirLLam);
            up.add(etiqueta_Tlf);
            up.add(tlf);
            up.add(etiqueta_Dur);
            up.add(duracion);
            add(up, BorderLayout.NORTH);
            JList mosllam = new JList();
            llam = new DefaultListModel();
            mosllam.setModel(llam);
            JScrollPane barra = new JScrollPane(mosllam);
            barra.setSize(100, 50);
            add(barra, BorderLayout.CENTER);


        }


    }

    private class CliEsc extends Escuchador {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton boton = (JButton) e.getSource();
            String texto = boton.getText();
            switch (texto) {
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
                case ("Cambiar precio"):
                    if (seleccionado == null) {
                        noSel();
                        break;
                    } else if (precio.getValue() instanceof Double || precio.getValue() instanceof Integer && (int) precio.getValue() * 1. > 0) {
                        super.controlador.swpPrecio(seleccionado, (int) precio.getValue() * 1.);
                    } else {
                        noVal();
                    }
                    break;
                case ("Añadir factura"):
                    if (seleccionado != null) {
                        super.controlador.addFac(seleccionado, LocalDateTime.now().minusDays(1));
                    } else {
                        noSel();
                    }
                    break;
                case ("Mostrar facturas"):
                    if (seleccionado != null) {
                        super.controlador.listFac(seleccionado);
                    } else {
                        noSel();
                    }
                    break;
                case ("Buscar factura"):
                    if (seleccionado != null) {
                        try {
                            super.controlador.buscaFac(parseInt(idfac.getText()));
                        } catch (Exception exc) {
                            invalidID();
                        }
                    } else {
                        noSel();
                    }
                    break;
                case ("Borra factura"):
                    if (seleccionado != null) {
                        try {
                            super.controlador.borraFac(parseInt(idfac.getText()));
                        } catch (Exception exc) {
                            invalidID();
                        }
                    } else {
                        noSel();
                    }
                    break;
                case ("Mostrar llamadas"):
                    if (seleccionado != null) {
                        super.controlador.listLlam(seleccionado);
                    } else {
                        noSel();
                    }
                    break;
                case ("Añadir llamadas"):
                    if (seleccionado != null) {
                        super.controlador.addLLam(seleccionado,tlf.getText(), (int) duracion.getValue());
                    } else {
                        noSel();
                    }
                    break;

            }

        }
    }
}


