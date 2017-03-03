import java.time.LocalDateTime;

/**
 * Created by al342052 on 21/02/2017.
 */
class Particular extends Cliente {

    private String apellidos;

    public Particular(String nombre, String apellidos, String nif, Direccion dir, LocalDateTime fecha, Tarifa tarifa) {
        super(nombre, nif, dir, fecha, tarifa);
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return apellidos + "," + super.toString();
    }

}
