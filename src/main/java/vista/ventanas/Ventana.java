package vista.ventanas;

import vista.escuchadores.Escuchador;

import javax.swing.*;

/**
 * Created by ouronok on 3/05/17.
 */
public abstract class Ventana extends JFrame implements Ventanas {

    Escuchador escuchador;
    
    @Override
    public void setListener(Escuchador escuchador) {
        this.escuchador=escuchador;
        crea();
    }

    protected abstract void crea();


    @Override
    public Escuchador getListener() {
        return escuchador;
    }
}
