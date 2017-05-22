package modelo.operaciones;

import modelo.datos.Direccion;
import modelo.clientes.Empresa;
import modelo.clientes.Particular;
import modelo.tarifas.Tarifa;

import java.io.Serializable;
import java.time.LocalDateTime;



public class FactoriaClientes implements Serializable {

    public Particular creaParticular(String nif, String nombre, String apellidos,  String email, Direccion dir, LocalDateTime fact, Tarifa tarifa) {
        return new Particular(nif, nombre, apellidos,  email, dir, fact, tarifa);
    }


    public Empresa creaEmpresa(String nif, String nombre,  String email, Direccion dir, LocalDateTime fact, Tarifa tarifa) {
        return new Empresa(nif, nombre,  email, dir, fact, tarifa);
    }
}



