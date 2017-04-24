import pago.Llamada;
import tarifas.Tarifa;
import org.junit.BeforeClass;
import org.junit.Test;
import tarifas.TarifaBasica;
import tarifas.TarifaDomingo;
import tarifas.TarifaTardes;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

/**
 * Este Test comprueba los métodos públicos de la clase Tarifa.
 */

public class TarifaTest{


    private static double precio;

    private static Tarifa tarifa,tarifa1,tarifa2,tarifa3;
    private static Llamada llam1,llam2,llam3;
    private static LocalDateTime fecha;


    @BeforeClass
    public static void init(){
        precio = (double) 20;
        tarifa = new TarifaBasica(precio);
        tarifa1 = new TarifaBasica(20.0);
        tarifa2 = new TarifaDomingo(tarifa1);
        tarifa3 = new TarifaTardes(tarifa1,10.0);
        fecha = LocalDateTime.now();
        llam1 = new Llamada("630183333",20,fecha,tarifa1);
        llam2 = new Llamada("630143333",20,fecha,tarifa2);
        llam3 = new Llamada("630113333",20,fecha,tarifa3);
    }



    @Test

    public void TestGetPrecio(){
        assertEquals(precio,tarifa.getPrecio(),0);
    }


    public void Loquesea(){



    }

}
