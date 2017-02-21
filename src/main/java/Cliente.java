import java.time.LocalDateTime;

/**
 * Created by al342052 on 21/02/2017.
 */
public abstract class Cliente {
    private String nombre;
    private String nif;
    private Direccion dir;
    private LocalDateTime fecha;
    private Tarifa tarifa;

    public Cliente(String nombre, String nif, Direccion dir, LocalDateTime fecha, Tarifa tarifa){
        this.nombre=nombre;
        this.nif=nif;
        this.dir=dir;
        this.fecha=fecha;
        this.tarifa=tarifa;
    }

    public LocalDateTime getFecha(){
        return fecha;
    }
}
