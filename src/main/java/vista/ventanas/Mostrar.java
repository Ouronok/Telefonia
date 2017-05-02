package vista.ventanas;

import vista.escuchadores.EscMos;
import vista.escuchadores.Escuchador;

import javax.swing.*;

/**
 * Created by ouronok on 2/05/17.
 */
public class Mostrar extends JFrame  implements Ventanas {
    Escuchador escuchador;

    @Override
    public void setListener(Escuchador escuchador) {
        this.escuchador=escuchador;
        crea();

    }

    private void crea() {

    }

    @Override
    public void setVisible(Boolean stat) {
        setVisible(stat);
    }

    @Override
    public Escuchador getListener() {
        return escuchador;
    }
}
