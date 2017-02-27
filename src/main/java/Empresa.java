import java.time.LocalDateTime;
import java.util.LinkedList;

/**
 * Created by al342052 on 21/02/2017.
 */
public class Empresa extends Cliente {

    public Empresa(String nombre, String nif, Direccion dir, LocalDateTime fecha, Tarifa tarifa){
        super(nombre,nif,dir,fecha,tarifa);
    }
}
