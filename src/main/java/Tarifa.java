import java.time.LocalDateTime;

/**
 * Created by al342052 on 21/02/2017.
 */
public class Tarifa {

    double precio;
    LocalDateTime fecha;

    public Tarifa(double precio, LocalDateTime fecha){
        this.precio=precio;
        this.fecha=fecha;
    }

    public double getPrecio(){
        return precio;
    }
}
