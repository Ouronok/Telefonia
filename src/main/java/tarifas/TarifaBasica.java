package tarifas;


public class TarifaBasica extends Tarifa {

    public TarifaBasica(double precio){
        super(precio);
    }
    @Override
    public double getPrecio(){
        return super.precio;
    }
}
