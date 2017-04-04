package tarifas;

import java.lang.Math;

public class TarifaDomingo extends Tarifa{
        private Tarifa tarifa;
        public TarifaDomingo(Tarifa tarifa){
            super(0);
            this.tarifa = tarifa;
        }
        @Override
        public double getPrecio(){
            return Math.min(tarifa.getPrecio(),super.precio);
        }
}
