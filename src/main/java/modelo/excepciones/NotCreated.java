package modelo.excepciones;


import java.io.Serializable;

public class NotCreated extends Exception implements Serializable {
    public NotCreated(){
        super("No se ha emitido una factura con dicho ID");
    }
}
