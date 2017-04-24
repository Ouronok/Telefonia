import pago.Llamada;
import org.junit.BeforeClass;
import org.junit.Test;
import tarifas.Tarifa;
import tarifas.TarifaBasica;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

/**
 * Este Test comprueba los métodos públicos de la clase pago.Llamada.
 */
public class LlamadaTest{

    private static LocalDateTime fecha;
    private static int duracion;
    private static Llamada llamadaTest;
    private static Tarifa tarifa;

    @BeforeClass

    public static void init(){
        String tlf = "964045938";
        duracion = 20;
        fecha = LocalDateTime.now();
        tarifa = new TarifaBasica(20.0);
        llamadaTest = new Llamada(tlf,duracion,fecha,tarifa);
    }


    @Test

    public void TestGetFecha(){
        assertEquals(llamadaTest.getFecha(),fecha);
    }

    @Test

    public void TestGetDuracion(){
        assertEquals(llamadaTest.getDuracion(),duracion);
    }


}
