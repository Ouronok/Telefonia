package modelo.excepciones;


import java.io.Serializable;

public class NotContained extends Exception implements Serializable {
    public NotContained(){
        super("No existe dicho cliente");
    }
}
