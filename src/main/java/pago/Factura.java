package pago;

import clientes.Cliente;
import datos.Dato;
import datos.Tarifa;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Factura implements Dato {

    private static int globalFID = 0;
    private Tarifa tarifa;
    private int fid;
    private LocalDateTime ffac;
    private LocalDateTime[] periodo = new LocalDateTime[2];
    private double importe;

    public Factura(LocalDateTime ffac, LocalDateTime f1, LocalDateTime f2, Cliente cliente, Tarifa tarifa) {
        globalFID++;
        fid = globalFID;
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

    public int getFid() {
        return fid;
    }

    private double getImporte(){
        return importe;
    }

    @Override
    public String toString() {
        return fid + "\n" + tarifa +"\n"+"Importe: "+importe+ "\n" + ffac + "\n Periodo: " + periodo[0] + "-" + periodo[1] + "\ndatos.Tarifa: " + tarifa.toString();
    }
}
