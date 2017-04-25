package modelo;

import java.time.LocalDateTime;



public class FactoriaClientes {

    public Particular creaParticular(String nombre, String apellidos, String nif, String email, Direccion dir, LocalDateTime fact, Tarifa tarifa) {
        return new Particular(nombre, apellidos, nif, email, dir, fact, tarifa);
    }


    public Empresa creaEmpresa(String nombre, String nif, String email, Direccion dir, LocalDateTime fact, Tarifa tarifa) {
        return new Empresa(nombre, nif, email, dir, fact, tarifa);
    }
}



