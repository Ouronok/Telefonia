package modelo;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Factura implements Dato, Serializable {
    private Tarifa tact;
    private int fid;
    private LocalDateTime ffac;
    private LocalDateTime[] periodo = new LocalDateTime[2];
    private double importe;

    public Factura(LocalDateTime ffac, LocalDateTime f1, LocalDateTime f2, Double importe, Tarifa tact) {
        int globalFID = 0;
        globalFID++;
        fid = globalFID;
        this.ffac = ffac;
        this.periodo[0] = f1;
        this.periodo[1] = f2;
        this.tact = tact;
        this.importe = importe;
    }

    public LocalDateTime getFecha() {
        return ffac;
    }


    public int getFID() {
        return fid;
    }


    @Override
    public String toString() {
        return "ID: " + fid + "\n" + "Tarifa: " + tact + "\n" + "Importe: " + importe + "€" + "\n" + "Fecha facturación: " +
                ffac + "\n" + "Periodo: " + periodo[0] + "  ---  " + periodo[1] + "\n";
    }
}
