import java.time.LocalDateTime;

/**
 * Created by al342052 on 21/02/2017.
 */
public class Factura {
    //un código único que no puede poseer ninguna otra factura, la tarifa aplicada  (€/min), la fecha de emisión de
    // la factura, el periodo de facturación (de qué fecha a qué fecha) y el importe de la misma. El importe de la factura
    // se calcula a partir de la suma de minutos de las llamadas que ha efectuado el cliente durante el periodo de facturación,
    // y de la tarifa.

    private static int GlobalFID=0;
    private int FID;
    private LocalDateTime ffac;
    private LocalDateTime[] periodo =  new LocalDateTime[2];
    private double importe;
    private Cliente cliente;

    public Factura(LocalDateTime ffac, LocalDateTime f1, LocalDateTime f2,Cliente cliente){
        GlobalFID++;
        FID=GlobalFID;
        importe= CalcularImporte(cliente);
        this.ffac=ffac;
        this.periodo[0]=f1;
        this.periodo[1]=f2;
    }
    public LocalDateTime getFecha(){
        return ffac;
    }

    private double CalcularImporte(Cliente cliente){

    }
}
