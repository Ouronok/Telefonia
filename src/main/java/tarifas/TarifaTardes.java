package tarifas;


public class TarifaTardes extends Tarifa {
    private Tarifa tarifa;

    public TarifaTardes(Tarifa tarifa, Double precio) {
        super(precio);
        this.tarifa = tarifa;
    }

    @Override
    public double getPrecio() {
        return Math.min(tarifa.getPrecio(), super.precio);
    }



}
