import aplicacion.FactoriaClientes;
import clientes.Cliente;
import clientes.Empresa;
import clientes.Particular;
import datos.Direccion;
import es.uji.www.GeneradorDatosINE;
import org.junit.BeforeClass;
import org.junit.Test;
import pago.Factura;
import pago.Llamada;
import tarifas.Tarifa;
import tarifas.TarifaBasica;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class FactoriaClientesTest {


    private static String nombre, NIF, apellidos, email, provincia, poblacion;
    private static Cliente empresa, particular;
    private static LocalDateTime fecha;
    private static Tarifa tarifa = new TarifaBasica(20);
    private static FactoriaClientes fcli;
    private static Direccion direccion;
    private static Llamada llam1;
    private static Llamada llam2;
    private static Factura factura1;

    @BeforeClass

    public static void init() {

        GeneradorDatosINE gen = new GeneradorDatosINE();
        nombre = gen.getNombre();
        apellidos = gen.getApellido();
        NIF = gen.getNIF();
        email = "pepe@gmail.com";
        provincia = gen.getProvincia();
        poblacion = gen.getPoblacion(provincia);
        direccion = new Direccion("12006", provincia, poblacion);
        fecha = LocalDateTime.now();
        particular = new Particular(nombre, apellidos, NIF, email, direccion, fecha, tarifa);
        empresa = new Empresa(nombre, NIF, email, direccion, fecha, tarifa);
        fcli = new FactoriaClientes();
    }

    @Test

    public void TestCreaParticular() {
        Cliente particular2;
        particular2 = fcli.creaParticular(nombre, apellidos, NIF, email, direccion, fecha, tarifa);
        assertEquals(particular,particular2);

    }

    @Test

    public void TestCreaEmpresa(){

        Cliente empresa2;
        empresa2 = fcli.creaEmpresa(nombre,NIF,email,direccion,fecha,tarifa);
        assertEquals(empresa,empresa2);

    }


}