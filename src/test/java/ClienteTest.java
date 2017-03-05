import es.uji.www.GeneradorDatosINE;
import org.junit.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

/**
 * Created by Pau on 05/03/2017.
 * Este Test comprueba los métodos publicos de la clase Cliente.
 */

public class ClienteTest{

    private static String nombre, apellido, NIF, provincia, poblacion;
    private static Direccion direccion;
    private static Cliente empresa, particular;
    private static LocalDateTime fecha;
    private static Tarifa tarifa = new Tarifa(20);
    private LinkedList<Llamada> listaLLamadas = new LinkedList<>();
    private static Llamada llam1;

    @BeforeClass
    public static void init(){

        GeneradorDatosINE gen = new GeneradorDatosINE();
        nombre = gen.getNombre();
        apellido = gen.getApellido();
        NIF = gen.getNIF();
        provincia = gen.getProvincia();
        poblacion = gen.getPoblacion(provincia);
        direccion = new Direccion("12006",provincia,poblacion);
        particular = new Particular(nombre,apellido,NIF,direccion,fecha,tarifa);
        empresa = new Empresa(nombre,NIF,direccion,fecha,tarifa);
        fecha = fecha.now();
        llam1 = new Llamada("964048351",20,fecha);
    }

    @Test
    public void getLlamadaPeriodo(){
        Llamada llam2 = new Llamada("943882182",15,fecha.minusDays(1));
        LinkedList<Llamada> original = particular.getListall();
        original.add(llam1);
        original.add(llam2);


    }

    @Test


    public void testSwapTarifa(){
        assertEquals(particular.getTarifa(),tarifa);
        Tarifa old = particular.getTarifa();
        Tarifa otra = new Tarifa(40);
        particular.swpTarifa(otra);
        assertEquals(otra,particular.getTarifa());
        particular.swpTarifa(old);


    }

    @Test

    public void testAddLlamada(){
        LinkedList<Llamada> original = particular.getListall();
        original.add(llam1);
        particular.addLlamada(llam1);
        assertEquals(original,particular.getListall());
    }


    @Test
    public void testGetNif(){

        assertEquals(particular.getNif(),NIF);
        assertEquals(empresa.getNif(),NIF);

    }

    @Test
    public void testGetTarifa(){
        assertEquals(particular.getTarifa(),tarifa);
        assertEquals(empresa.getTarifa(),tarifa);
    }

    @Test

    public void testAddFactura(){
        LinkedList<Factura> original = particular.getListafac();
        Factura newFactura = new Factura(fecha,fecha.minusMinutes(30),
                fecha.minusMinutes(10),particular,tarifa);
        original.add(newFactura);
        particular.addFactura(newFactura);
        assertEquals(original,particular.getListafac());

    }


    @After
    public void remove(){
        particular.getListall().clear();
    }


}