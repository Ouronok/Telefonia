package aplicacion;


import tarifas.Tarifa;
import tarifas.TarifaBasica;
import tarifas.TarifaDomingo;
import tarifas.TarifaTardes;



public class FactoriaTarifas {


    public static TarifaBasica creaTarifa(Double precio) {
        return new TarifaBasica(precio);
    }

    public static TarifaDomingo creaDomingo(Tarifa tarifa) {
        return new TarifaDomingo(tarifa);
    }

    public static TarifaTardes creaTardes(Tarifa tarifa) {
        return new TarifaTardes(tarifa, (double) 10);
    }
}

