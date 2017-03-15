package excepciones;

/**
 * Created by ouron on 15/03/2017.
 */
public class NotContained extends Exception {
    public NotContained(){
        super("No existe dicho cliente");
    }
}
