import es.uji.www.GeneradorDatosINE;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

/**
 * Created by Pau on 05/03/2017.
 * Este Test comprueba los métodos publicos de la clase llamada. COMPLETO
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
