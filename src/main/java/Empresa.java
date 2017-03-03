import java.time.LocalDateTime;


class Empresa extends Cliente {

    public Empresa(String nombre, String nif, Direccion dir, LocalDateTime fecha, Tarifa tarifa) {
        super(nombre, nif, dir, fecha, tarifa);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
