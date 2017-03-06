import es.uji.www.GeneradorDatosINE;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Este Test comprueba los métodos públicos de la clase Direccion
 */
public class DireccionTest{

    private static String cp;
    private static String provincia;
    private static String poblacion;
    private static Direccion direccionTest;

    @BeforeClass
    public static void init(){
        GeneradorDatosINE gen = new GeneradorDatosINE();
        cp = "12006";
        provincia = gen.getProvincia();
        poblacion = gen.getPoblacion(provincia);
        direccionTest = new Direccion(cp,provincia,poblacion);

    }

    @Test
    public void testGetCp(){
        assertEquals(direccionTest.getCp(),cp);
    }

    @Test
    public void testGetProvincia(){assertEquals(direccionTest.getProvincia(),provincia);
    }

    @Test
    public void testGetPoblacion()

    {
        assertEquals(direccionTest.getPoblacion(),poblacion);
    }


}