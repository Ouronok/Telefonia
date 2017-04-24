import aplicacion.FactoriaTarifas;
import org.junit.BeforeClass;
import org.junit.Test;
import tarifas.Tarifa;
import tarifas.TarifaBasica;
import tarifas.TarifaDomingo;
import tarifas.TarifaTardes;

import static junitx.framework.Assert.assertEquals;

public class FactoriaTarifasTest {

    private static Tarifa tarifa1,tarifa2,tarifa3,prueba;
    private static FactoriaTarifas ftar;

    @BeforeClass

    public static void  init(){
        tarifa1 = new TarifaBasica(20.0);
        tarifa2 = new TarifaDomingo(tarifa1);
        tarifa3 = new TarifaTardes(tarifa1,10.0);

    }



    @Test

    public void TestCreaTarifa(){
        prueba = FactoriaTarifas.creaTarifa(20.0);
        assertEquals(prueba,tarifa1);

    }


    @Test
    public void TestCreaDomingo(){
        prueba = FactoriaTarifas.creaDomingo(tarifa1);
        assertEquals(prueba, tarifa2);
    }

    @Test
    public void TestCreaTardes(){
        prueba = FactoriaTarifas.creaTardes(tarifa1);
        assertEquals(prueba,tarifa3);
    }


}
