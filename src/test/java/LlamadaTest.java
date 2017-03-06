import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

/**
 * Este Test comprueba los métodos públicos de la clase Llamada.
 */
public class LlamadaTest{

    private static LocalDateTime fecha;
    private static int duracion;
    private static Llamada llamadaTest;

    @BeforeClass

    public static void init(){
        String tlf = "964045938";
        duracion = 20;
        fecha = LocalDateTime.now();
        llamadaTest = new Llamada(tlf,duracion,fecha);
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
