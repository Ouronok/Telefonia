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
    private Double precio =  15.0; //Por defecto




    public void creaEmpresa(String nombre, String nif, String email, String cp, String provincia, String poblacion) {
        Empresa cliente = fcli.creaEmpresa(nombre, nif, email, new Direccion(cp,provincia,poblacion), fact, fta.creaTarifa((precio)));
        addCliente(cliente);
    }


    public void creaParticular(String nombre, String apellidos, String nif, String email, String cp, String provincia, String poblacion) {
        Particular cliente = fcli.creaParticular(nombre, apellidos, nif, email, new Direccion(cp,provincia,poblacion), fact, fta.creaTarifa(precio));
        addCliente(cliente);
    }

    public void addCliente(Cliente cliente) {
        for (Cliente cliac : clientes) {
            if (cliac.getNif().equals(cliente.getNif())) {
                vista.clienteNoAnyadido();
                return;
            }
        }
        clientes.add(cliente);
        System.out.println("hola");
        vista.clienteAnyadido();
        return;
    }

    public void swpTarifa(int op,Cliente cliente) {
        switch(op){
            case(1):
                cliente.swpTarifa(FactoriaTarifas.creaDomingo(cliente.getTarifa()));
                vista.tarifaCambiada();
                return;
            case(2):
                cliente.swpTarifa(FactoriaTarifas.creaTardes(cliente.getTarifa()));
                vista.tarifaCambiada();
                return;
            case(3):
                cliente.swpTarifa(FactoriaTarifas.creaTarifa(20.));
                vista.tarifaCambiada();
        }
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

    public void swpPrecio(Cliente cliente, double precio) {
       cliente.getTarifa().swpPrecio(precio);
       vista.tarifaCambiada();
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

    public void emitirFactura(Cliente cliente, LocalDateTime[] intervalo)  {
        double importe = calcImp(cliente, intervalo);
        cliente.addFactura(new Factura(fact, intervalo[0],intervalo[1], importe, cliente.getTarifa()));
        vista.facan();
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



    public void setVista(InformaVista vista) {
        this.vista = vista;
    }
}
