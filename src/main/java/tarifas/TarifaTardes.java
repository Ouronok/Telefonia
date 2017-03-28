package tarifas;

/**
 * Created by ouron on 28/03/2017.
 */
public class TarifaTardes extends Tarifa {
    private Tarifa tarifa;
    public TarifaTardes(Tarifa tarifa, Double precio){
        super(precio);
        this.tarifa = tarifa;
    }
    @Override
    public String descripcion(){
        return "Tarifa de tardes mas barata";
    }

}
