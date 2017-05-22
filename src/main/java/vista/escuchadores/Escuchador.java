package vista.escuchadores;

import controlador.Controlador;

import java.awt.event.ActionListener;
import java.io.Serializable;

/**
 * Created by ouronok on 2/05/17.
 */
public abstract class Escuchador implements ActionListener, Serializable {
    public Controlador controlador;

    public void setControlador(Controlador controlador){
        this.controlador=controlador;
    }

}
