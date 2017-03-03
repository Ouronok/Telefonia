public class Tarifa {

    private double precio;

    Tarifa(double precio) {
        this.precio = precio;
    }

    double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return precio + "€";
    }
}
