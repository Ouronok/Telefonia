import java.time.LocalDateTime;

/**
 * Created by al342052 on 21/02/2017.
 */
public class Llamada {
    // teléfono al que se llamó, la fecha y hora de la llamada y la duración.
    private String tlf;
    private LocalDateTime fecha;
    private int duracion;

    public Llamada(String tlf, int duracion, LocalDateTime fecha){
        this.tlf=tlf;
        this.duracion=duracion;
        this.fecha=fecha;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }
    public int getDuracion(){
        return duracion;
    }
}
