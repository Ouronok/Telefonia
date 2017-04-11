package aplicacion;

import clientes.Cliente;
import clientes.Empresa;
import clientes.Particular;
import datos.Direccion;
import excepciones.BadPeriod;
import excepciones.NotContained;
import excepciones.NotCreated;
import pago.Factura;
import pago.Llamada;
import tarifas.Tarifa;
import tarifas.TarifaBasica;
import tarifas.TarifaDomingo;
import tarifas.TarifaTardes;

import java.time.LocalDateTime;
import java.util.LinkedList;

class Factoria {

    LinkedList creaLista() {
        return new LinkedList<>();
    }

    Particular creaParticular(String nombre, String apellidos, String nif, String email, Direccion dir, LocalDateTime fact, Double precio) {
        TarifaBasica tarifa = creaTarifa(precio);
        return new Particular(nombre, apellidos, nif, email, dir, fact, tarifa);
    }

    Empresa creaEmpresa(String nombre, String nif, String email, Direccion dir, LocalDateTime fact, Double precio) {
        Tarifa tarifa = creaTarifa(precio);
        return new Empresa(nombre, nif, email, dir, fact, tarifa);
    }

    TarifaBasica creaTarifa(Double precio) {
        return new TarifaBasica(precio);
    }

    Llamada creaLlamada(String tlf, int duracion, LocalDateTime fecha, Tarifa tarifa) {
        return new Llamada(tlf, duracion, fecha, tarifa);
    }

    BadPeriod creaBadPeriod() {
        return new BadPeriod();
    }

    NotContained creaNotContained() {
        return new NotContained();
    }

    NotCreated creaNotCreated() {
        return new NotCreated();
    }

    Factura creaFactura(LocalDateTime fact, LocalDateTime[] intervalo, Cliente cliente, Tarifa tarifa) {
        return new Factura(fact, intervalo[0], intervalo[1], cliente, tarifa);
    }

    Direccion crearDir(String[] val) {
        return new Direccion(val[0], val[1], val[2]);
    }

    public TarifaDomingo creaTarifaDomingo(Tarifa tarifa) {
        return new TarifaDomingo(tarifa);
    }

    public TarifaTardes creaTarifaTarde(Tarifa tarifa) {
        return new TarifaTardes(tarifa, (double) 10);
    }
}
