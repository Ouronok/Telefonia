import es.uji.www.GeneradorDatosINE;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;


/**
 * Created by al341845 on 28/02/2017.
 * Este Test comprueba los métodos publicos de la clase Factura.
 */
public class FacturaTest{

    private static LocalDateTime fecha;
    private static Tarifa tarifa = new Tarifa(20);
    private static int FID;
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
        Cliente particular = new Particular(nombre,apellido,NIF,email,direccion,fecha,tarifa);
        Cliente empresa = new Empresa(nombre,NIF,email,direccion,fecha,tarifa);
        FID = 0;
        facturaPart = new Factura(fecha,fecha.minusMinutes(30),
                fecha.minusMinutes(10),particular,tarifa);
        facturaEmp = new Factura(fecha,fecha.minusMinutes(30),
                fecha.minusMinutes(10),empresa,tarifa);

        System.out.println(FID);
        System.out.println(facturaPart.getFid() - 1);

    }

    @Test

    public void testGetFID(){
        assertEquals(facturaPart.getFid(),FID + 1); //Se incrementa en 1 porque es la primera factura
        assertEquals(facturaEmp.getFid(),FID + 2); //Se incrementa en 2 porque es la segunda factura

    }

    @Test
    public void testGetFecha(){

        assertEquals(facturaPart.getFecha(),fecha);
        assertEquals(facturaEmp.getFecha(),fecha);
    }


}