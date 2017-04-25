package modelo.excepciones;

public class BadPeriod extends Exception {
    public BadPeriod(){
        super("La fecha dos no puede ser despues de la primera");
    }
}
