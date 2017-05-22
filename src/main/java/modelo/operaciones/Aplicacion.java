package modelo.operaciones;

import modelo.CambioModelo;
import modelo.InterrogaModelo;
import modelo.clientes.*;
import modelo.datos.*;
import modelo.excepciones.*;

import vista.InformaVista;

import java.io.*;
import java.time.LocalDateTime;
import java.util.LinkedList;


public class Aplicacion implements Serializable, CambioModelo, InterrogaModelo {
    private final LocalDateTime fact = LocalDateTime.now();
    private FactoriaClientes fcli = new FactoriaClientes();
    private FactoriaTarifas fta = new FactoriaTarifas();
    private LinkedList<Cliente> clientes = new LinkedList<>();
    private InformaVista vista;
    private Double precio =  15.0; //Por defecto




    public void creaEmpresa(String nif, String nombre , String email, String cp, String provincia, String poblacion) {
        Empresa cliente = fcli.creaEmpresa( nif, nombre, email, new Direccion(cp,provincia,poblacion), fact, fta.creaTarifa((precio)));
        addCliente(cliente);
    }


    public void creaParticular(String nif,String nombre, String apellidos,  String email, String cp, String provincia, String poblacion) {
        Particular cliente = fcli.creaParticular(nif, nombre, apellidos, email, new Direccion(cp,provincia,poblacion), fact, fta.creaTarifa(precio));
        addCliente(cliente);
    }

    private void addCliente(Cliente cliente) {
        for (Cliente cliac : clientes) {
            if (cliac.getNif().equals(cliente.getNif())) {
                vista.clienteNoAnyadido();
                return;
            }
        }
        clientes.add(cliente);
        vista.clienteAnyadido();
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

    public Cliente delCliente(String dni) throws NotContained {
        for (Cliente cliact: clientes) {
            if (cliact.getNif().equals(dni)) {
                clientes.remove(cliact);
                return cliact;
            }
        }
        throw new NotContained();
    }


    public LinkedList<Llamada> getLlamadas(Cliente cliente) {
        return cliente.getListall();
    }

    @Override
    public void emitirLlamada(Cliente cliente, String tlf, int duracion, LocalDateTime fecha) {
        cliente.addLlamada(new Llamada(tlf, duracion, fecha));
    }

    @Override
    public void save() {
        try{
            File fichero = new File("app.bin");
            FileOutputStream fos = new FileOutputStream(fichero);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.close();

            vista.saveSuccesful();
        } catch (IOException e) {
             System.out.println(e.getMessage());
            vista.saveError();
        }
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
        throw new NotContained(vista);
    }



    public void getClientes() {
        vista.getClientes(clientes);
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

    public Factura getFactura(int cod){
        for (Cliente cliac : clientes) {
            for (Factura faac : cliac.getListafac()) {
                if (faac.getFID() == cod) {
                    return faac;
                }
            }
        }
        return null;
    }

    public boolean delFac(int cod){
        for (Cliente cliac : clientes) {
            for (Factura faac : cliac.getListafac()) {
                if (faac.getFID() == cod) {
                    cliac.delFac(faac);
                    return true;
                }
            }
        }
        return false;
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
