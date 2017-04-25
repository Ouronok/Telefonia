package modelo.clientes;

import modelo.datos.Direccion;
import modelo.tarifas.Tarifa;

import java.time.LocalDateTime;


public class Empresa extends Cliente {

    public Empresa(String nombre, String nif, String email, Direccion dir, LocalDateTime fecha, Tarifa tarifa) {
        super(nombre, nif, email, dir, fecha, tarifa);
    }

}
