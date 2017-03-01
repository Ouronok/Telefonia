import java.time.LocalDateTime;

/**
 * Created by al342052 on 21/02/2017.
 */
class Empresa extends Cliente {

    public Empresa(String nombre, String nif, Direccion dir, LocalDateTime fecha, Tarifa tarifa) {
        super(nombre, nif, dir, fecha, tarifa);
    }
}
