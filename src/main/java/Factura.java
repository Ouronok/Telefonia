import java.time.LocalDateTime;
import java.util.LinkedList;

public class Factura {

    private static int GlobalFID = 0;
    private Tarifa tarifa;
    private int FID;
    private LocalDateTime ffac;
    private LocalDateTime[] periodo = new LocalDateTime[2];
    private double importe;

    Factura(LocalDateTime ffac, LocalDateTime f1, LocalDateTime f2, Cliente cliente, Tarifa tarifa) {
        GlobalFID++;
        FID = GlobalFID;
        CalcularImporte(cliente);
        this.ffac = ffac;
        this.periodo[0] = f1;
        this.periodo[1] = f2;
        this.tarifa = tarifa;
    }

    public LocalDateTime getFecha() {
        return ffac;
    }

    private void CalcularImporte(Cliente cliente) {
        LinkedList<Llamada> llper = cliente.getLlamadaPeriodo(periodo);
        for (Llamada llact : llper) {
            importe += llact.getDuracion() * tarifa.getPrecio();
        }
    }

    int getFID() {
        return FID;
    }

    @Override
    public String toString() {
        return FID + "\n" + tarifa + "\n" + ffac + "\n Periodo: " + periodo[0] + "-" + periodo[1] + "\nTarifa: " + tarifa.toString();
    }
}
