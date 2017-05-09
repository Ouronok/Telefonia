package vista.ventanas;

import vista.escuchadores.Escuchador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by al341845 on 09/05/2017.
 */
public class Operaciones extends Ventana{


    private Container contenedor;

    @Override
    public void crea() {
        super.setTitle("Operaciones disponibles");
        super.escuchador = new EscuchaOperaciones();
        contenedor = getContentPane();
        rellena();
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);





    }

    private void rellena(){

        JTabbedPane pestanyas = new JTabbedPane();
        pestanyas.add("Añadir Cliente",new PannelAnyadir());
        pestanyas.add("Borrar Cliente",new PannelBorrar());
        contenedor.add(pestanyas);
    }


    private class PannelAnyadir extends JPanel{
        public PannelAnyadir() {
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

    private class PannelBorrar extends JPanel{

        JTextField nombre = new JTextField(25);
        JTextField nif = new JTextField(8);
        JCheckBox empresa = new JCheckBox();
        JTextField direccion =  new JTextField(30) ;
        JTextField email =  new JTextField(20);

    }



    private class EscuchaOperaciones extends Escuchador {

        @Override
        public void actionPerformed(ActionEvent e) {


        }
    }
}
