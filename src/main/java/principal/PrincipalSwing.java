package principal;

import controlador.Manejo;
import modelo.operaciones.Aplicacion;
import vista.Interfaz;

import javax.swing.*;

/**
 * Created by ouron on 01/05/2017.
 */
public class PrincipalSwing {
    public static void main(String args[]){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Manejo controlador = new Manejo();
                Interfaz vista = new Interfaz();
                Aplicacion modelo = new Aplicacion();
                vista.setControlador(controlador);
                vista.setModelo(modelo);
                modelo.setVista(vista);
                controlador.setModelo(modelo);
                controlador.setVista(vista);
            }
        });









    }
}
