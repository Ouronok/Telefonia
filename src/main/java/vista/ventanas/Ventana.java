package vista.ventanas;


import vista.escuchadores.Escuchador;

import javax.swing.*;
import java.io.Serializable;

public abstract class Ventana extends JFrame implements Ventanas, Serializable {

    Escuchador escuchador;


    Ventana(){
        crea();
    }

    protected abstract void crea();

    @Override
    public Escuchador getListener() {
        return escuchador;
    }





}
