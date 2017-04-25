import modelo.Cliente;
import modelo.Empresa;
import modelo.Particular;
import modelo.Direccion;
import modelo.Tarifa;
import modelo.Factura;
import es.uji.www.GeneradorDatosINE;
import org.junit.BeforeClass;
import org.junit.Test;
import modelo.TarifaBasica;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;


/**
 * Este Test comprueba los métodos publicos de la clase modelo.Factura.
 */
public class FacturaTest{

    private static LocalDateTime fecha;
    private static Factura facturaPart;
    private static Factura facturaEmp;


    @BeforeClass
    public static void init(){
        GeneradorDatosINE generador = new GeneradorDatosINE();
        String nombre = generador.getNombre();
        String apellido = generador.getApellido();
        String NIF = generador.getNIF();
        String email = "pepe@gmail.com";
        String provincia = generador.getProvincia();
        String poblacion = generador.getPoblacion(provincia);
        Direccion direccion = new Direccion("12006",provincia,poblacion);
        fecha = LocalDateTime.now();
        Tarifa tarifa = new TarifaBasica(20);
        Cliente particular = new Particular(nombre,apellido,NIF,email,direccion,fecha,tarifa);
        Cliente empresa = new Empresa(nombre,NIF,email,direccion,fecha,tarifa);
        facturaPart = new Factura(fecha,fecha.minusMinutes(30), fecha.minusMinutes(10),300.0,tarifa);
        facturaEmp = new Factura(fecha,fecha.minusMinutes(30), fecha.minusMinutes(10),200.0,tarifa);

    }

    @Test
    public void testGetFecha(){

        assertEquals(facturaPart.getFecha(),fecha);
        assertEquals(facturaEmp.getFecha(),fecha);
    }




}