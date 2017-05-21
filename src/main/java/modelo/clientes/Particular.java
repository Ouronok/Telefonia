package modelo.clientes;

import modelo.datos.Direccion;
import modelo.tarifas.Tarifa;

import java.time.LocalDateTime;


public class Particular extends Cliente {

    private String apellidos;

    public Particular(String nif, String nombre, String apellidos , String email, Direccion dir, LocalDateTime fecha, Tarifa tarifa) {
        super(nif, nombre, email, dir, fecha, tarifa);
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "[Particular]    " + "Apellidos: " +  apellidos + "      " + super.toString();
    }

}
