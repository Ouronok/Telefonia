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


    TarifaBasica creaTarifa(Double precio) {
        return new TarifaBasica(precio);
    }

    public static TarifaDomingo creaDomingo(Tarifa tarifa) {
        return new TarifaDomingo(tarifa);
    }

    public static TarifaTardes creaTardes(Tarifa tarifa) {
        return new TarifaTardes(tarifa, (double) 10);
    }
}

