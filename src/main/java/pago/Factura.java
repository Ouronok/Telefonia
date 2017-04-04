package pago;

import clientes.Cliente;
import datos.Dato;
import tarifas.Tarifa;
import tarifas.TarifaBasica;
import tarifas.TarifaDomingo;
import tarifas.TarifaTardes;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class Factura implements Dato, Serializable {

    private Tarifa tact;
    private Tarifa tbas= new TarifaBasica(15);
    private int fid;
    private LocalDateTime ffac;
    private LocalDateTime[] periodo = new LocalDateTime[2];
    private double importe;

    public Factura(LocalDateTime ffac, LocalDateTime f1, LocalDateTime f2, Cliente cliente, Tarifa tact) {
        int globalFID = 0;
        globalFID++;
        fid = globalFID;
        CalcularImporte(cliente);
        this.ffac = ffac;
        this.periodo[0] = f1;
        this.periodo[1] = f2;
        this.tact = tact;
    }

    public LocalDateTime getFecha() {
        return ffac;
    }

    private void CalcularImporte(Cliente cliente) {
        LinkedList<Llamada> llper = cliente.getLlamadaPeriodo(periodo);
        for (Llamada llact : llper) {
            checkTime(llact);
            importe += tact.getPrecioLlamada(llact);
        }
    }

    private void checkTime(Llamada llact) {
        if (llact.getFecha().getDayOfWeek()== DayOfWeek.SUNDAY){
            tact = new TarifaDomingo(tact);
        } else if(llact.getFecha().getHour()>=16 && llact.getFecha().getHour()<=20){
            tact = new TarifaTardes(tact, 0.5);
        } else {
            tact = tbas;
        }

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
