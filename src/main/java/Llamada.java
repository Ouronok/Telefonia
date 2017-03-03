import java.time.LocalDateTime;


class Llamada {

    private String tlf;
    private LocalDateTime fecha;
    private int duracion;

    Llamada(String tlf, int duracion, LocalDateTime fecha) {
        this.tlf = tlf;
        this.duracion = duracion;
        this.fecha = fecha;
    }

    LocalDateTime getFecha() {
        return fecha;
    }

    int getDuracion() {
        return duracion;
    }

    @Override
    public String toString() {
        return "Telefono llamado: " + tlf + "\n Duracion: " + duracion + "\n Fecha: " + fecha.toString();
    }
}
