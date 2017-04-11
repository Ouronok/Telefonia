package tarifas;


import pago.Llamada;

public class TarifaTardes extends TarifaEspecial {

    public TarifaTardes(Tarifa tarifa, Double precio) {
        super(precio,tarifa);

    }

    @Override
    public double precioLlamada(Llamada llamada) {
        if(llamada.getFecha().getHour() >= 16 && llamada.getFecha().getHour() <= 20){
            return Math.min(precioLlamada(llamada), getRecubierta().precioLlamada(llamada));
        }
        return getRecubierta().precioLlamada(llamada);
    }


}
