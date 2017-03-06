import es.uji.www.GeneradorDatosINE;
import org.junit.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

/**
 * Created by Pau on 05/03/2017.
 * Este Test comprueba los métodos publicos de la clase Cliente.
 */

public class ClienteTest {

    private static String nombre, apellido, NIF, provincia, poblacion;
    private static Direccion direccion;
    private static Cliente empresa, particular;
    private static LocalDateTime fecha;
    private static Tarifa tarifa = new Tarifa (20);
    private LinkedList<Llamada> listaLLamadas = new LinkedList<> ();
    private static Llamada llam1;
    private static Llamada llam2;
    private static Factura factura1;
    @BeforeClass
    public static void init() {

        GeneradorDatosINE gen = new GeneradorDatosINE ();
        nombre = gen.getNombre ();
        apellido = gen.getApellido ();
        NIF = gen.getNIF ();
        provincia = gen.getProvincia ();
        poblacion = gen.getPoblacion (provincia);
        direccion = new Direccion ("12006", provincia, poblacion);
        particular = new Particular (nombre, apellido, NIF, direccion, fecha, tarifa);
        empresa = new Empresa (nombre, NIF, direccion, fecha, tarifa);
        fecha = fecha.now ();
        llam1 = new Llamada ("964048351", 20, fecha.minusHours (1));
        llam2 = new Llamada ("943882182", 15, fecha.minusDays (1));
        factura1 = new Factura(fecha,fecha.minusMinutes(30),
                fecha.minusMinutes(10),particular,tarifa);
    }

  /*  @Test
    public void getLlamadaPeriodo(){

        LinkedList<Llamada> original = particular.getListall();
        original.add(llam1);
        original.add(llam2);
        particular.addLlamada (llam1);
        particular.addLlamada (llam2);
        LocalDateTime[] periodo = new LocalDateTime[2];
        periodo[0] = fecha.minusDays (3);
        periodo[1] = fecha;
        LinkedList<Llamada> resultado = particular.getLlamadaPeriodo(periodo);
        assertEquals (original,particular.getLlamadaPeriodo (periodo));

        }
 */


    @Test


    public void testSwapTarifa() {
        assertEquals (particular.getTarifa (), tarifa);
        Tarifa old = particular.getTarifa ();
        Tarifa otra = new Tarifa (40);

        particular.swpTarifa (otra);
        assertEquals (otra, particular.getTarifa ());
        particular.swpTarifa (old);
    }


    @Test
    public void testAddLlamada() {
        LinkedList<Llamada> original = particular.getListall ();
        original.add (llam1);
        particular.addLlamada (llam1);
        assertEquals (original, particular.getListall ());
    }


    @Test
    public void testGetNif() {

        assertEquals (particular.getNif (), NIF);
        assertEquals (empresa.getNif (), NIF);

    }

    @Test
    public void testGetListall() {
        LinkedList<Llamada> esperado = new LinkedList<Llamada> ();
        esperado.add (llam1);
        particular.addLlamada (llam1);
        LinkedList<Llamada> resultado = particular.getListall ();
        assertEquals (esperado, resultado);
    }

    @Test
    public void testGetTarifa() {
        assertEquals (particular.getTarifa (), tarifa);
        assertEquals (empresa.getTarifa (), tarifa);
    }

    @Test

    public void testAddFactura() {
        LinkedList<Factura> original = particular.getListafac ();
        Factura newFactura = new Factura (fecha, fecha.minusMinutes (30),
                fecha.minusMinutes (10), particular, tarifa);
        original.add (newFactura);
        particular.addFactura (newFactura);
        assertEquals (original, particular.getListafac ());

    }

    @Test
    public void testGetListaFac() {
        LinkedList<Factura> esperado = new LinkedList<Factura>();
        esperado.add (factura1);
        particular.addFactura (factura1);
        LinkedList<Factura> original = particular.getListafac ();
        assertEquals (original,esperado);
    }



    @After
    public void remove() {
        particular.getListall ().clear ();
        particular.getListafac ().clear ();

    }


}