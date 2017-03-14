import aplicacion.Aplicacion;
import clientes.Cliente;
import clientes.Empresa;
import clientes.Particular;
import datos.Direccion;
import datos.Tarifa;
import pago.Factura;
import pago.Llamada;
import es.uji.www.GeneradorDatosINE;
import junitx.framework.ListAssert;
import org.junit.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import static org.junit.Assert.assertEquals;

public class AplicacionTest {

    private static String NIF;
    private static Cliente empresa, particular;
    private static LocalDateTime fecha;
    private static Tarifa tarifa = new Tarifa(20);
    private static Llamada llam1;
    private static Llamada llam2;
    private static Factura factura1;
    private static Factura factura2;
    private static LinkedList<Cliente> clientes;
    private static LinkedList<Llamada> llamadas;
    private static LinkedList<Factura> facturas;
    private static Aplicacion app;

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
        particular = new Particular(nombre,apellido,NIF,email,direccion,fecha.minusDays(2),tarifa);
        empresa = new Empresa(nombre,NIF,email,direccion,fecha.minusDays(4),tarifa);
        fecha = LocalDateTime.now();
        llam1 = new Llamada("964048351",20,fecha.minusDays(2));
        llam2 = new Llamada("943882182",15,fecha.minusDays(4));
        factura1 = new Factura(fecha,fecha.minusMinutes(5),fecha.minusDays(2),particular,tarifa);
        factura2 = new Factura(fecha,fecha.minusDays(2),fecha.minusDays(4),particular,tarifa);
        clientes = new LinkedList<>();
        llamadas = new LinkedList<>();
        app = new Aplicacion();
        particular.addFactura(factura1);
        particular.addFactura(factura2);
        particular.addLlamada(llam1);
        particular.addLlamada(llam2);
        app.addCliente(empresa);
        app.addCliente(particular);




    }


    @Test
    public void getList(){
        clientes.add(particular);

        LinkedList<Cliente> comp = new LinkedList<>();
        comp.add(particular);
        ListAssert.assertEquals(app.getList(app.getClientes(),fecha.minusDays(3),fecha),clientes);
        llamadas.add(llam2);
        ListAssert.assertEquals(app.getLlamadas(particular,fecha.minusDays(3),fecha),llamadas);
        facturas.add(factura1);
        ListAssert.assertEquals(app.getLlamadas(particular,fecha.minusDays(3),fecha),llamadas);
    }
}
