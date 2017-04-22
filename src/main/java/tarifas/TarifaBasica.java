package tarifas;


import pago.Llamada;

public class TarifaBasica extends Tarifa {

    public TarifaBasica(double precio){
        super(precio);
    }

    @Override
    public double precioLlamada(Llamada llamada) {
        return getPrecio() * llamada.getDuracion();
    }

    @Override
    public double getPrecio(){
        return super.precio;
    }


    public void swpPrecio(double precio) {
        super.precio=precio;
    }
}
