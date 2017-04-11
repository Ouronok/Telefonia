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


public class FactoriaTarifas {

    BadPeriod creaBadPeriod() {
        return new BadPeriod();
    }

    TarifaBasica creaTarifa(Double precio) {
        return new TarifaBasica(precio);
    }

    public TarifaDomingo creaTarifaDomingo(Tarifa tarifa) {
        return new TarifaDomingo(tarifa);
    }

    public TarifaTardes creaTarifaTarde(Tarifa tarifa) {
        return new TarifaTardes(tarifa, (double) 10);
    }
}

