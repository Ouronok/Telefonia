package modelo.excepciones;

import java.io.Serializable;

public class BadPeriod extends Exception implements Serializable {
    public BadPeriod(){
        super("La fecha dos no puede ser despues de la primera");
    }
}
