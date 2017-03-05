import es.uji.www.GeneradorDatosINE;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by Pau on 05/03/2017.
 */
public class DireccionTest {

    public static String provincia;
    public static String cp;
    public static String poblacion;
    public static Direccion direccionTest;

    @BeforeClass
    public static void init(){
        GeneradorDatosINE gen = new GeneradorDatosINE();
        provincia = gen.getProvincia();
        poblacion = gen.getPoblacion(provincia);
        cp = "12006";
        direccionTest = new Direccion(cp,provincia,poblacion);

    }

    @Test
    public void testGetCp()

    {

        assertEquals(direccionTest.getCp(),cp);

    }

    @Test
    public void testGetProvincia()

    {
        assertEquals(direccionTest.getProvincia(),provincia);
    }


    @Test
    public void testGetPoblacion()

    {
        assertEquals(direccionTest.getPoblacion(),poblacion);
    }


}