package vista.ventanas;

import modelo.clientes.Cliente;
import vista.escuchadores.Escuchador;

import javax.swing.*;
import java.io.Serializable;

/**
 * Created by ouronok on 3/05/17.
 */
public abstract class Ventana extends JFrame implements Ventanas, Serializable {

    Escuchador escuchador;


    public Ventana(){
        crea();
    }

    protected abstract void crea();

    @Override
    public Escuchador getListener() {
        return escuchador;
    }





}
