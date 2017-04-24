package aplicacion;


import org.jetbrains.annotations.NotNull;
import tarifas.Tarifa;
import tarifas.TarifaBasica;
import tarifas.TarifaDomingo;
import tarifas.TarifaTardes;



public class FactoriaTarifas {


    @NotNull
    public static TarifaBasica creaTarifa(Double precio) {
        return new TarifaBasica(precio);
    }

    @NotNull
    public static TarifaDomingo creaDomingo(Tarifa tarifa) {
        return new TarifaDomingo(tarifa);
    }

    @NotNull
    public static TarifaTardes creaTardes(Tarifa tarifa) {
        return new TarifaTardes(tarifa, (double) 10);
    }
}

