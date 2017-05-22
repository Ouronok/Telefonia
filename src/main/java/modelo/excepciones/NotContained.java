package modelo.excepciones;


import vista.InformaVista;

import java.io.Serializable;

public class NotContained extends Exception implements Serializable {

    private InformaVista vista;

    public NotContained(){
        super("No existe dicho cliente");
        vista.noCli();
    }

    public NotContained(InformaVista vista) {
        this.vista=vista;
    }
}
