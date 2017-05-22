package modelo.datos;

import modelo.tarifas.Tarifa;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Factura implements Dato, Serializable {
    private Tarifa tact;
    private int fid;
    private LocalDateTime ffac;
    private LocalDateTime[] periodo = new LocalDateTime[2];
    private double importe;
    private static int globalFID = 0;

    public Factura(LocalDateTime ffac, LocalDateTime f1, LocalDateTime f2, Double importe, Tarifa tact) {
        fid = createID();
        this.ffac = ffac;
        this.periodo[0] = f1;
        this.periodo[1] = f2;
        this.tact = tact;
        this.importe = importe;
    }

    private static synchronized int createID() {
        return globalFID++;
    }

    public LocalDateTime getFecha() {
        return ffac;
    }


    public int getFID() {
        return fid;
    }


    @Override
    public String toString() {
        return "ID: " + fid + "     Tarifa: " + tact + "        Importe: " + importe + " €" + "     Fecha facturación: " +
                ffac  + "       Periodo: " + periodo[0] + "  ---  " + periodo[1];
    }
}
