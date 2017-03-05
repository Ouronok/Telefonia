import es.uji.www.GeneradorDatosINE;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;


/**
 * Created by al341845 on 28/02/2017.
 */
public class FacturaTest{

    public static LocalDateTime fecha;
    private static Tarifa tarifa;
    private static int FID;
    private static LocalDateTime ffac;
    private static double importe;
    private static Cliente cliente;
    private static Cliente empresa;
    private static Factura facturaCli;
    private static Factura facturaEmp;

    @BeforeClass
    public static void init(){
        GeneradorDatosINE generador = new GeneradorDatosINE();
        String nombre = generador.getNombre();
        String apellido = generador.getApellido();
        String NIF = generador.getNIF();
        String provincia = generador.getProvincia();
        String poblacion = generador.getPoblacion(provincia);
        Direccion direccion = new Direccion("12006",provincia,poblacion);
        fecha = LocalDateTime.now();
        tarifa = new Tarifa(20);
        cliente = new Particular(nombre,apellido,NIF,direccion,fecha,tarifa);
        empresa = new Empresa(nombre,NIF,direccion,fecha,tarifa);
        FID = 0;
        facturaCli = new Factura(fecha,fecha.minusMinutes(30),
                fecha.minusMinutes(10),cliente,tarifa);
        facturaEmp = new Factura(fecha,fecha.minusMinutes(30),
                fecha.minusMinutes(10),empresa,tarifa);

        System.out.println(FID);
        System.out.println(facturaCli.getFID() -1 );

    }

    @Test

    public void testGetFID(){
        assertEquals(facturaCli.getFID() ,FID +1); //Se incrementa en 1 porque es la primera factura
        assertEquals(facturaEmp.getFID() ,FID +2); //Se incrementa en 2 porque es la segunda factura

    }

    @Test
    public void testGetFecha(){

        assertEquals(facturaCli.getFecha(),fecha);
        assertEquals(facturaEmp.getFecha(),fecha);
    }



}