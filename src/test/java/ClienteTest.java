import es.uji.www.GeneradorDatosINE;
import org.junit.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

/**
 * Este Test comprueba los métodos públicos de la clase Cliente.
 */

public class ClienteTest{

    private static String NIF;
    private static Cliente empresa, particular;
    private static LocalDateTime fecha;
    private static Tarifa tarifa = new Tarifa(20);
    private static Llamada llam1;
    private static Llamada llam2;
    private static Factura factura1;

    @BeforeClass
    public static void init(){

        GeneradorDatosINE gen = new GeneradorDatosINE();
        String nombre = gen.getNombre();
        String apellido = gen.getApellido();
        NIF = gen.getNIF();
        String email = "pepe@gmail.com";
        String provincia = gen.getProvincia();
        String poblacion = gen.getPoblacion(provincia);
        Direccion direccion = new Direccion("12006",provincia,poblacion);
        particular = new Particular(nombre,apellido,NIF,email,direccion,fecha,tarifa);
        empresa = new Empresa(nombre,NIF,email,direccion,fecha,tarifa);
        fecha = LocalDateTime.now();
        llam1 = new Llamada("964048351",20,fecha.minusHours(1));
        llam2 = new Llamada("943882182",15,fecha.minusDays(1));
        factura1 = new Factura(fecha,fecha.minusMinutes(30),
                fecha.minusMinutes(10),particular,tarifa);
    }

    @Test
    public void getLlamadaPeriodo(){ //Hay algún conflicto con las fechas que no llegamos a resolver

        LinkedList<Llamada> original = particular.getListall();
        original.add(llam1);
        original.add(llam2);
        particular.addLlamada(llam1);
        particular.addLlamada(llam2);
        LocalDateTime[] periodo = new LocalDateTime[2];
        periodo[0] = fecha.minusDays(3);
        periodo[1] = fecha;
        assertEquals(original,particular.getLlamadaPeriodo(periodo));

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
    public void testGetListall(){
        LinkedList<Llamada> esperado = new LinkedList<>();
        esperado.add(llam1);
        particular.addLlamada(llam1);
        LinkedList<Llamada> resultado = particular.getListall();
        assertEquals(esperado,resultado);
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

    @Test
    public void testGetListaFac(){
        LinkedList<Factura> esperado = new LinkedList<>();
        esperado.add(factura1);
        particular.addFactura(factura1);
        LinkedList<Factura> original = particular.getListafac();
        assertEquals(original,esperado);
    }


    @After
    public void remove(){
        particular.getListall().clear();
        particular.getListafac().clear();

    }


}