package vista.ventanas;

import vista.escuchadores.Escuchador;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by ouronok on 2/05/17.
 */
public interface Ventanas {
    void setListener(Escuchador escuchador);
    Escuchador getListener();

}
