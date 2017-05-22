package modelo.operaciones;


import modelo.tarifas.Tarifa;
import modelo.tarifas.TarifaBasica;
import modelo.tarifas.TarifaDomingo;
import modelo.tarifas.TarifaTardes;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;


public class FactoriaTarifas implements Serializable {


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

