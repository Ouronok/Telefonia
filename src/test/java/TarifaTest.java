import pago.Llamada;
import tarifas.Tarifa;
import org.junit.BeforeClass;
import org.junit.Test;
import tarifas.TarifaBasica;
import tarifas.TarifaDomingo;
import tarifas.TarifaTardes;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

/**
 * Este Test comprueba los métodos públicos de la clase Tarifa.
 */

public class TarifaTest{


    private static double precio;

    private static Tarifa tarifa,tarifa1,tarifa2,tarifa3;
    private static Llamada llam1,llam2,llam3;
    private static LocalDateTime fecha;
    private static int duracion;


    @BeforeClass
    public static void init(){
        precio = (double) 20;
        tarifa = new TarifaBasica(precio);
        duracion = 20;
        tarifa1 = new TarifaBasica(20.0);  //TARIFA ESTANDAR
        tarifa2 = new TarifaDomingo(tarifa1);     //TARIFA DE DOMINGO
        tarifa3 = new TarifaTardes(tarifa1,10.0);  //TARIFA DE TARDES
        fecha = LocalDateTime.now();
        llam1 = new Llamada("630183333",duracion,fecha,tarifa1); //LLAMADA CON TARIFA NORMAL
        llam2 = new Llamada("630143333",duracion,fecha.minusDays(1),tarifa2); //LLAMADA CON TARIFA DE DOMINGO EN DOMINGO (CAMBIAR MANUALMENTE)
        llam3 = new Llamada("630113333",duracion,fecha.minusHours(5),tarifa3); //LLAMADA CON TARIFA DE TARDES LLAMANDO POR LA TARDE (CAMBIAR MANUALMENTE)
    }



    @Test
    public void TestGetPrecio(){

        assertEquals(precio,tarifa.getPrecio(),0);
    }

@Test
    public void TestPrecioLlamada(){
        assertEquals(tarifa1.precioLlamada(llam1),tarifa1.getPrecio()* duracion,0);
        assertEquals(tarifa2.precioLlamada(llam2),tarifa2.getPrecio()*duracion,0);
        assertEquals(tarifa3.precioLlamada(llam3),tarifa3.getPrecio()*duracion,0);


    }

}
