package tarifas;

/**
 * Created by ouron on 28/03/2017.
 */
public class TarifaDomingo extends Tarifa{
        private Tarifa tarifa;
        public TarifaDomingo(Tarifa tarifa){
            super(0);
            this.tarifa = tarifa;
        }
        @Override
        public String descripcion(){
            return "Tarifa de domingo gratuita";
        }

}
