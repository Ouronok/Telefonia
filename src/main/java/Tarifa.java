import java.time.LocalDateTime;

/**
 * Created by al342052 on 21/02/2017.
 */
public class Tarifa {

    double precio;

    public Tarifa(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return precio + "€";
    }
}
