package modelo;


import java.time.DayOfWeek;

public class TarifaDomingo extends TarifaEspecial {
    public TarifaDomingo(Tarifa tarifa) {
        super(0, tarifa);
    }

    @Override
    public double precioLlamada(Llamada llamada) {
        if (llamada.getFecha().getDayOfWeek() == DayOfWeek.SUNDAY)
            return 0;
        else return getRecubierta().precioLlamada(llamada);
    }

    @Override
    public double getPrecio() {
        return 0;
    }
}