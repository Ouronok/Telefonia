package vista.escuchadores;

import controlador.Controlador;

import java.awt.event.ActionListener;

/**
 * Created by ouronok on 2/05/17.
 */
public abstract class Escuchador implements ActionListener {
    public Controlador controlador;

    public void setControlador(Controlador controlador){
        this.controlador=controlador;
    }

}
