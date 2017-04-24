import clientes.Cliente;
import clientes.Empresa;
import clientes.Particular;
import datos.Direccion;
import tarifas.Tarifa;
import pago.Factura;
import pago.Llamada;
import es.uji.www.GeneradorDatosINE;
import org.junit.*;
import tarifas.TarifaBasica;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

/**
 * Este Test comprueba los métodos públicos de la clase Cliente.
 */

public class ClienteTest {

    private static String NIF;
    private static Cliente empresa, particular;
    private static LocalDateTime fecha;
    private static Tarifa tarifa = new TarifaBasica(20);
    private static Llamada llam1;
    private static Llamada llam2;
    private static Factura factura1;

    @BeforeClass
    public static void init() {

        GeneradorDatosINE gen = new GeneradorDatosINE();
        String nombre = gen.getNombre();
        String apellido = gen.getApellido();
        NIF = gen.getNIF();
        String email = "pepe@gmail.com";
        String provincia = gen.getProvincia();
        String poblacion = gen.getPoblacion(provincia);
        Direccion direccion = new Direccion("12006", provincia, poblacion);
        fecha = LocalDateTime.now();
        particular = new Particular(nombre, apellido, NIF, email, direccion, fecha, tarifa);
        empresa = new Empresa(nombre, NIF, email, direccion, fecha, tarifa);
        llam1 = new Llamada("964048351", 20, fecha.minusHours(1),tarifa);
        llam2 = new Llamada("943882182", 15, fecha.minusDays(1),tarifa);
        factura1 = new Factura(fecha, fecha.minusMinutes(30),
                fecha.minusMinutes(10), 500.0, tarifa);
    }

    @Test
    public void testGetLlamadaPeriodo() { //Hay algún conflicto con las fechas que no llegamos a resolver

        LinkedList<Llamada> prueba = new LinkedList<>();
        particular.addLlamada(llam1);
        particular.addLlamada(llam2);
        prueba.add(llam1);
        prueba.add(llam2);
        LinkedList<Llamada> resultado = particular.getListall();

        LocalDateTime[] periodo = new LocalDateTime[2];
        periodo[0] = fecha.minusDays(3);
        periodo[1] = fecha;
        for (Llamada elemento: prueba){
            if(elemento.getFecha().isAfter(periodo[0]) && elemento.getFecha().isBefore(periodo[1]))
                resultado.add(elemento);
        }
        assertEquals(particular.getLlamadaPeriodo(periodo), resultado);


    }


    @Test


    public void testSwapTarifa() {
        assertEquals(particular.getTarifa(), tarifa);
        Tarifa old = particular.getTarifa();
        Tarifa otra = new TarifaBasica(40);

        particular.swpTarifa(otra);
        assertEquals(otra, particular.getTarifa());
        particular.swpTarifa(old);
    }


    @Test
    public void testAddLlamada() {
        LinkedList<Llamada> original = particular.getListall();
        original.add(llam1);
        particular.addLlamada(llam1);
        assertEquals(original, particular.getListall());
    }


    @Test
    public void testGetNif() {

        assertEquals(particular.getNif(), NIF);
        assertEquals(empresa.getNif(), NIF);

    }

    @Test
    public void testGetListall() {
        LinkedList<Llamada> esperado = new LinkedList<>();
        esperado.add(llam1);
        particular.addLlamada(llam1);
        LinkedList<Llamada> resultado = particular.getListall();
        assertEquals(esperado, resultado);
    }

    @Test
    public void testGetTarifa() {
        assertEquals(particular.getTarifa(), tarifa);
        assertEquals(empresa.getTarifa(), tarifa);
    }

    @Test

    public void testAddFactura() {
        LinkedList<Factura> original = particular.getListafac();
        Factura newFactura = new Factura(fecha, fecha.minusMinutes(30),
                fecha.minusMinutes(10), 500.0, tarifa);
        original.add(newFactura);
        particular.addFactura(newFactura);
        assertEquals(original, particular.getListafac());

    }

    @Test
    public void testGetListaFac() {
        LinkedList<Factura> esperado = new LinkedList<>();
        esperado.add(factura1);
        particular.addFactura(factura1);
        LinkedList<Factura> original = particular.getListafac();
        assertEquals(original, esperado);
    }


    @After
    public void remove() {
        particular.getListall().clear();
        particular.getListafac().clear();

    }


}