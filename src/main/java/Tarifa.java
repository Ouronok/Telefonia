/**
 * Created by al342052 on 21/02/2017.
 */
public class Tarifa {

    private double precio;

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
