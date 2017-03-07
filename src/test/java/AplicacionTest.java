import es.uji.www.GeneradorDatosINE;
import org.junit.*;
import java.time.LocalDateTime;
import java.util.LinkedList;

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
        particular = new Particular(nombre,apellido,NIF,email,direccion,fecha.minusDays(4),tarifa);
        empresa = new Empresa(nombre,NIF,email,direccion,fecha.minusDays(4),tarifa);
        fecha = LocalDateTime.now();
        llam1 = new Llamada("964048351",20,fecha.minusHours(4));
        llam2 = new Llamada("943882182",15,fecha.minusDays(2));
        factura1 = new Factura(fecha,fecha.minusMinutes(5),fecha.minusMinutes(4),particular,tarifa);
        factura2 = new Factura(fecha,fecha.minusDays(2),fecha.minusDays(1),particular,tarifa);
        clientes = new LinkedList<>();
        llamadas = new LinkedList<>();
        clientes.add(particular);
        llamadas.add(llam2);

    }
    @Test
    public void getList(){

    }
}
