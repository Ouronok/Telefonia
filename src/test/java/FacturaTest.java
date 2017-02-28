import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.*;


/**
 * Created by al341845 on 28/02/2017.
 */
public class FacturaTest {

    @Test

    public void calcularImporte(){

        double importe = 100;
        Tarifa tar = new Tarifa(20);
        Direccion dir = new Direccion("papa", "papa", "papa");
        Cliente particular = new Particular("Pepe","sanguijuela","20489083Q",dir, LocalDateTime.now(),tar);







    }
}
