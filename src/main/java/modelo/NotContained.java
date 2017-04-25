package modelo;


public class NotContained extends Exception {
    public NotContained(){
        super("No existe dicho cliente");
    }
}
