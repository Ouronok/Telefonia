package principal;

import controlador.Manejo;
import modelo.operaciones.Aplicacion;
import vista.Interfaz;

import javax.swing.*;
import java.io.*;


public class PrincipalSwing {

    private static Aplicacion modelo;
    private static Interfaz vista;

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Manejo controlador = new Manejo();
                vista = new Interfaz();
                initModelo();
                vista.setControlador(controlador);
                vista.setModelo(modelo);
                modelo.setVista(vista);
                controlador.setModelo(modelo);
                controlador.setVista(vista);
            }
        });


    }

    private static void initModelo(){
        try {
            load();
        } catch (Exception e) {
            modelo = new Aplicacion();
        }
    }

    private static void load() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("app.bin");
        ObjectInputStream ois = new ObjectInputStream(fis);
        modelo = (Aplicacion)ois.readObject();
        ois.close();
    }

}
