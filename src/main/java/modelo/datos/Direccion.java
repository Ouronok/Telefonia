package modelo.datos;

import java.io.Serializable;

public class Direccion implements Serializable {
    private String cp;
    private String provincia;
    private String poblacion;

    public Direccion(String cp, String provincia, String poblacion) {
        this.cp = cp;
        this.provincia = provincia;
        this.poblacion = poblacion;
    }

    @Override
    public String toString() {
        return "Provincia: "  + provincia + "      Población: " + poblacion + "      Codigo postal: " + cp;
    }
}
