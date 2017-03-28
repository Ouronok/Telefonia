import tarifas.Tarifa;
import org.junit.BeforeClass;
import org.junit.Test;
import tarifas.TarifaBasica;

import static org.junit.Assert.assertEquals;

/**
 * Este Test comprueba los métodos públicos de la clase Tarifa.
 */

public class TarifaTest{


    private static double precio;

    private static Tarifa tarifa;

    @BeforeClass
    public static void init(){
        precio = (double) 20;
        tarifa = new TarifaBasica(precio);
    }



    @Test

    public void TestGetPrecio(){
        assertEquals(precio,tarifa.getPrecio(),0);
    }

}
