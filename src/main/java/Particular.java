import java.time.LocalDateTime;


class Particular extends Cliente {

    private String apellidos;

    public Particular(String nombre, String apellidos, String nif, String email, Direccion dir, LocalDateTime fecha, Tarifa tarifa) {
        super(nombre, nif, email, dir, fecha, tarifa);
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return apellidos + "," + super.toString();
    }

}
