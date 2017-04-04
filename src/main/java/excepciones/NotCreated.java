package excepciones;


public class NotCreated extends Exception {
    public NotCreated(){
        super("No se ha emitido una factura con dicho ID");
    }
}
