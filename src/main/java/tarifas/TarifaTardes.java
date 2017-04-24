package tarifas;


import pago.Llamada;

public class TarifaTardes extends TarifaEspecial {

    public TarifaTardes(Tarifa tarifa, Double precio) {
        super(precio,tarifa);

    }

    @Override
    public double precioLlamada(Llamada llamada) {
        if(llamada.getFecha().getHour() >= 16 && llamada.getFecha().getHour() <= 20){
            return Math.min(this.getPrecio() * llamada.getDuracion(), getRecubierta().getPrecio() * llamada.getDuracion());
        }
        return getRecubierta().precioLlamada(llamada);
    }

    @Override
    public double getPrecio() {
        return super.precio;
    }


}
