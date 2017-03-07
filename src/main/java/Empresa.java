import java.time.LocalDateTime;


class Empresa extends Cliente {

    public Empresa(String nombre, String nif, String email, Direccion dir, LocalDateTime fecha, Tarifa tarifa) {
        super(nombre, nif, email, dir, fecha, tarifa);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
