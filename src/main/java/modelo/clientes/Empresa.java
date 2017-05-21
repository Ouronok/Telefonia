package modelo.clientes;

import modelo.datos.Direccion;
import modelo.tarifas.Tarifa;

import java.time.LocalDateTime;


public class Empresa extends Cliente {

    public Empresa(String nif, String nombre , String email, Direccion dir, LocalDateTime fecha, Tarifa tarifa) {
        super(nif, nombre , email, dir, fecha, tarifa);
    }

    @Override
    public String toString() {
        return "[Empresa]    " + super.toString();
    }

}
