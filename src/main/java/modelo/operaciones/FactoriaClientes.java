package modelo.operaciones;

import modelo.datos.Direccion;
import modelo.clientes.Empresa;
import modelo.clientes.Particular;
import modelo.tarifas.Tarifa;

import java.time.LocalDateTime;



public class FactoriaClientes {

    public Particular creaParticular(String nombre, String apellidos, String nif, String email, Direccion dir, LocalDateTime fact, Tarifa tarifa) {
        return new Particular(nombre, apellidos, nif, email, dir, fact, tarifa);
    }


    public Empresa creaEmpresa(String nombre, String nif, String email, Direccion dir, LocalDateTime fact, Tarifa tarifa) {
        return new Empresa(nombre, nif, email, dir, fact, tarifa);
    }
}



