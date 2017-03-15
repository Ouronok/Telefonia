package excepciones;

/**
 * Created by ouron on 15/03/2017.
 */
public class NotCreated extends Exception {
    public NotCreated(){
        super("No se ha emitido una factura con dicho ID");
    }
}
