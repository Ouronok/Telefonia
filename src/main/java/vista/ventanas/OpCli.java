package vista.ventanas;

import modelo.InterrogaModelo;
import modelo.clientes.Cliente;
import modelo.datos.Factura;
import vista.escuchadores.Escuchador;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.NumberFormat;
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
    private JTextField idfac;

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

    public void mostrarFacturas(LinkedList<Factura> facturas) {
        fac.removeAllElements();
        for(Factura faca:facturas){
            fac.addElement(faca);
        }
    }

    public void facan() {
        JOptionPane.showMessageDialog(this,"Factura añadida con exito");
    }

    public void noFac() {
        JOptionPane.showMessageDialog(this,"No existe dicha factura");
    }

    public void muestraFactura(Factura factura) {
        fac.addElement(factura);
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
            add(down,BorderLayout.CENTER);




        }

    }

    private class PanelFacturas extends JPanel{
        public PanelFacturas(){
            setLayout(new BorderLayout());
            JPanel up = new JPanel();
            idfac = new JTextField(3);
            JLabel idtxt = new JLabel("ID factura: ");
            JButton busfac = new JButton("Buscar factura");
            JButton delfac = new JButton("Borra factura");
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
            add(up,BorderLayout.NORTH);
            JList mosfac = new JList();
            fac = new DefaultListModel();
            mosfac.setModel(fac);
            JScrollPane barra = new JScrollPane(mosfac);
            barra.setSize(100,50);
            add(barra, BorderLayout.CENTER);
        }
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
                    break;
                case("Añadir factura"):
                    if(seleccionado!=null) {
                        super.controlador.addFac(seleccionado, LocalDateTime.now());
                    }else{
                        noSel();
                    }
                    break;
                case("Mostrar facturas"):
                    if(seleccionado!=null) {
                        super.controlador.listFac(seleccionado);
                    }else {
                        noSel();
                    }
                    break;
                case("Buscar factura"):
                    if(seleccionado!=null) {
                        super.controlador.buscaFac(parseInt(idfac.getText()));
                    }else{
                        noSel();
                    }
                    break;
                case("Borra factura"):
                    if(seleccionado!=null) {
                        super.controlador.borraFac(parseInt(idfac.getText()));
                    }else{
                        noSel();
                    }
            }
        }

    }
}

