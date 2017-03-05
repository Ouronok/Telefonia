import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Pau on 05/03/2017.
 */
public class TarifaTest{


    public static double precio;
    public static Tarifa tarifa;

    @BeforeClass
    public static void init(){
        precio = (double) 20;
        tarifa = new Tarifa(precio);
    }

    @Test
    public void TestGetPrecio(){
      assertEquals(precio,tarifa.getPrecio(),0);
    }

}
