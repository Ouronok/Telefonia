package modelo.operaciones;

import modelo.CambioModelo;
import modelo.InterrogaModelo;
import modelo.clientes.*;
import modelo.datos.*;
import modelo.excepciones.*;
import modelo.tarifas.TarifaBasica;
import vista.InformaVista;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedList;


public class Aplicacion implements Serializable, CambioModelo, InterrogaModelo {
    private final LocalDateTime fact = LocalDateTime.now();
    private FactoriaClientes fcli = new FactoriaClientes();
    private FactoriaTarifas fta = new FactoriaTarifas();
    private LinkedList<Cliente> clientes = new LinkedList<>();
    private InformaVista vista;




    public void creaEmpresa(String nombre, String nif, String email, String[] dir, Double precio) {
        Empresa cliente = fcli.creaEmpresa(nombre, nif, email, crearDir(dir), fact, fta.creaTarifa(precio));
        addCliente(cliente);
    }


    public void creaParticular(String nombre, String apellidos, String nif, String email, String[] dir, Double precio) {
        Particular cliente = fcli.creaParticular(nombre, apellidos, nif, email, crearDir(dir), fact, fta.creaTarifa(precio));
        addCliente(cliente);
    }

    public boolean addCliente(Cliente cliente) {
        for (Cliente cliac : clientes) {
            if (cliac.getNif().equals(cliente.getNif())) {
                return false;
            }
        }
        clientes.add(cliente);
        return true;
    }

    public boolean delCliente(Cliente cliente) {
        if (clientes.contains(cliente)) {
            clientes.remove(cliente);
            return true;
        }
        return false;
    }

    private Direccion crearDir(String[] dir) {
        return new Direccion(dir[0],dir[1],dir[2]);
    }

    public boolean swpPrecio(Cliente cliente, double precio) {
        if (clientes.contains(cliente)) {
            if(cliente.getTarifa() instanceof TarifaBasica){
                ((TarifaBasica) cliente.getTarifa()).swpPrecio(precio);
                return true;
            }
        }
        return false;
    }

    public Cliente getCliente(String nif) throws NotContained {
        for (Cliente cAct : clientes) {
            if (cAct.getNif().equals(nif)) {
                return cAct;
            }
        }
        throw new NotContained();
    }

    public void getClientes() {
        clientes.add(new Empresa("Pepe","20","naranyes",new Direccion("oeoe","jdjd","jdhd"),LocalDateTime.now(),new TarifaBasica(20)));
        vista.getClientes(clientes);
    }

    public boolean addLlamada(String tlf, int duracion, LocalDateTime fecha, Cliente cliente) {

        return clientes.contains(cliente) && cliente.addLlamada(new Llamada(tlf, duracion, fecha,cliente.getTarifa()));
    }



    public LinkedList<Llamada> getLlamadas(Cliente cliente) {
        if (clientes.contains(cliente)) {
            return cliente.getListall();
        }
        return null;
    }

    public boolean emitirFactura(Cliente cliente, LocalDateTime[] intervalo) throws BadPeriod, NotContained {
        if (intervalo[0].isAfter(intervalo[1])) {
            throw new BadPeriod();
        }

        if (!clientes.contains(cliente)) {
            throw new NotContained();
        }
        double importe = calcImp(cliente, intervalo);
        return cliente.addFactura(new Factura(fact, intervalo[0],intervalo[1], importe, cliente.getTarifa()));
    }

    private double calcImp(Cliente cliente, LocalDateTime[] intervalo) {
        double importe=0;
        for(Llamada llac : cliente.getListall()){
            if(llac.getFecha().isAfter(intervalo[0]) && llac.getFecha().isBefore(intervalo[1])){
                importe+= cliente.getTarifa().precioLlamada(llac);
            }
        }
        return importe;
    }

    public Factura getFactura(int cod) throws NotCreated {
        for (Cliente cliac : clientes) {
            for (Factura faac : cliac.getListafac()) {
                if (faac.getFID() == cod) {
                    return faac;
                }
            }
        }
        throw new NotCreated();
    }

    public LinkedList<Factura> getFacturas(Cliente cliente) {
        return cliente.getListafac();
    }

    public <T extends Dato> LinkedList<T> getList(LinkedList<T> list, LocalDateTime fecha1, LocalDateTime fecha2) throws BadPeriod {
        if (fecha1.isAfter(fecha2)) throw new BadPeriod();

        LinkedList<T> retList = new LinkedList<>();
        for(T elem : list){
            LocalDateTime fecha = elem.getFecha();
            if(fecha.isAfter(fecha1) && fecha.isBefore(fecha2)){
                retList.add(elem);
            }
        }
        return retList;
    }


    public boolean swpTarifa(int op,Cliente cliente) {
        switch(op){
            case(1):
                cliente.swpTarifa(FactoriaTarifas.creaDomingo(cliente.getTarifa()));
                return true;
            case(2):
                cliente.swpTarifa(FactoriaTarifas.creaTardes(cliente.getTarifa()));
                return true;
            default:
                System.out.println("Opcion invalida");
                return false;

        }
    }

    public void setVista(InformaVista vista) {
        this.vista = vista;
    }
}
