package modelo.tarifas;

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
