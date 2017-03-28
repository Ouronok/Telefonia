package tarifas;

/**
 * Created by ouron on 28/03/2017.
 */
public class TarifaBasica extends Tarifa {

    public TarifaBasica(double precio){
        super(precio);
    }
    @Override
    public double getPrecio(){
        return super.precio;
    }
    @Override
    public String descripcion(){
        return "Tarifa basica de precio fijo";
    }
}
