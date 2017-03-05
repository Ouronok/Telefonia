import es.uji.www.GeneradorDatosINE;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

/**
 * Created by Pau on 05/03/2017.
 */
public class LlamadaTest {

    public static String tlf;
    public static LocalDateTime fecha;
    public static int duracion;
    public static Llamada llamadaTest;

    @BeforeClass

    public static void init(){

        GeneradorDatosINE gen = new GeneradorDatosINE();
        tlf = "964045938";
        duracion = 20;
        fecha = LocalDateTime.now();
        llamadaTest = new Llamada(tlf,duracion,fecha);
    }


    @Test

    public void TestGetFecha(){
        assertEquals(llamadaTest.getFecha(),fecha);
    }


}
