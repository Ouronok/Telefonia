package tarifas;

import pago.Llamada;


import java.time.DayOfWeek;

public class TarifaDomingo extends TarifaEspecial {
//        private Tarifa tarifa;
        public TarifaDomingo(Tarifa tarifa){
            super(0, tarifa);
        }

    @Override
    public double precioLlamada(Llamada llamada) {
        if(llamada.getFecha().getDayOfWeek() == DayOfWeek.SUNDAY)
            return 0;
        else return getRecubierta().precioLlamada(llamada);
    }

    @Override
    public double getPrecio() {
        return 0;
    }

//    @Override
//        public double getPrecio(){
//            return Math.min(tarifa.getPrecio(),super.precio);
//        }
}
