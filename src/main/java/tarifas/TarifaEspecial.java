package tarifas;

/**
 * Created by al342052 on 11/04/2017.
 */
public abstract class TarifaEspecial extends Tarifa {
    private Tarifa recubierta;

    public TarifaEspecial(double precio, Tarifa recubierta) {
        super(precio);
        this.recubierta = recubierta;
    }

    public Tarifa getRecubierta() {
        return recubierta;
    }
}
