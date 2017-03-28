package pago;

import clientes.Cliente;
import datos.Dato;
import tarifas.Tarifa;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class Factura implements Dato, Serializable {

    private int globalFID = 0;
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
            importe += tarifa.getPrecioLlamada(llact);
        }
    }

    public int getFID() {
        return fid;
    }


    @Override
    public String toString() {
        return "ID: " + fid + "\n" + "Tarifa: " + tarifa + "\n" + "Importe: " + importe + "€" + "\n" + "Fecha facturación: " +
                ffac + "\n" + "Periodo: " + periodo[0] + "  ---  " + periodo[1] + "\n";
    }
}
