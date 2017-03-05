import es.uji.www.GeneradorDatosINE;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by al341845 on 05/03/2017.
 * Este Test comprueba los métodos publicos de la clase Direccion.COMPLETO
 */
public class DireccionTest{

    private static String provincia;
    private static String cp;
    private static String poblacion;
    private static Direccion direccionTest;

    @BeforeClass
    public static void init(){
        GeneradorDatosINE gen = new GeneradorDatosINE();
        provincia = gen.getProvincia();
        poblacion = gen.getPoblacion(provincia);
        cp = "12006";
        direccionTest = new Direccion(cp,provincia,poblacion);

    }

    @Test
    public void testGetCp(){
        assertEquals(direccionTest.getCp(),cp);
    }

    @Test
    public void testGetProvincia(){

        assertEquals(direccionTest.getProvincia(),provincia);
    }


    @Test
    public void testGetPoblacion()

    {
        assertEquals(direccionTest.getPoblacion(),poblacion);
    }


}