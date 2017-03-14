package excepciones;

/**
 * Created by ouron on 14/03/2017.
 */
public class BadPeriod extends Exception {
    private BadPeriod(){
        super("La fecha dos no puede ser despues de la primera");
    }
}
