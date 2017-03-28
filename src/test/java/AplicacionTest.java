import aplicacion.Aplicacion;
import clientes.Cliente;
import clientes.Empresa;
import clientes.Particular;
import datos.Direccion;
import tarifas.*;
import excepciones.BadPeriod;
import junitx.framework.ListAssert;
import pago.Factura;
import pago.Llamada;
import es.uji.www.GeneradorDatosINE;
import org.junit.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static junitx.framework.Assert.assertEquals;

/**
 * Este Test comprueba los métodos públicos de la clase Aplicación.
 */

public class AplicacionTest {

    private static Empresa empresa;
    private static Particular particular;
    private static LocalDateTime fecha = LocalDateTime.now();
    private static Tarifa tarifa = new TarifaBasica(20);
    private static Llamada llam1;
    private static Llamada llam2;
    private static Factura factura1;
    private static Factura factura2;
    private static LinkedList<Cliente> clientes;
    private static LinkedList<Llamada> llamadas;
    private static LinkedList<Factura> facturas;
    private static Aplicacion app;

    @BeforeClass
    public static void init() {


        GeneradorDatosINE gen = new GeneradorDatosINE();
        String nombre = gen.getNombre();
        String apellidos = gen.getApellido();
        String NIF = gen.getNIF();
        String email = "pepe@gmail.com";
        String provincia = gen.getProvincia();
        String poblacion = gen.getPoblacion(provincia);
        Direccion direccion = new Direccion("12006", provincia, poblacion);
        particular = new Particular(nombre, apellidos, "20489083Q", email, direccion, fecha.minusDays(2), tarifa);
        empresa = new Empresa(nombre, NIF, email, direccion, fecha.minusDays(4), tarifa);
        fecha = LocalDateTime.now();
        llam1 = new Llamada("964048351", 20, fecha.minusDays(2));
        llam2 = new Llamada("943882182", 15, fecha.minusDays(4));
        factura1 = new Factura(fecha.minusDays(2), fecha.minusDays(6), fecha.minusDays(2), particular, tarifa);
        factura2 = new Factura(fecha.minusDays(11), fecha.minusDays(2), fecha.minusDays(1), particular, tarifa);
        clientes = new LinkedList<>();
        llamadas = new LinkedList<>();
        facturas = new LinkedList<>();
        app = new Aplicacion();
        particular.addFactura(factura1);
        particular.addFactura(factura2);
        particular.addLlamada(llam1);
        particular.addLlamada(llam2);
        app.addCliente(empresa);
        app.addCliente(particular);


    }


    @Test
    public void testGetFacturas() {

        facturas.add(factura1);
        facturas.add(factura2);
        assertEquals(app.getFacturas(particular), facturas);


    }

    @Test
    public void testGetClientes() {
        clientes.add(empresa);
        clientes.add(particular);
        assertEquals(app.getClientes(), clientes);
    }

    @Test
    public void testGetLlamadas() {

        llamadas.add(llam1);
        llamadas.add(llam2);
        assertEquals(app.getLlamadas(particular), llamadas);
    }


    @Test
    public void getListTest() throws BadPeriod {

        clientes.add(particular);
        ListAssert.assertEquals(app.getList(app.getClientes(), fecha.minusDays(3), fecha), clientes);
        llamadas.add(llam1);
        ListAssert.assertEquals(app.getList(particular.getListall(), fecha.minusDays(3), fecha), llamadas);
        facturas.add(factura1);
        assertEquals(app.getList(particular.getListafac(), fecha.minusDays(10), fecha), facturas);

    }

    @After
    public void clean() {
        clientes = new LinkedList<>();
        llamadas = new LinkedList<>();
        facturas = new LinkedList<>();
    }


}
