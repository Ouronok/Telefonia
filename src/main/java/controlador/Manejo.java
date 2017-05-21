package controlador;

import modelo.CambioModelo;
import modelo.clientes.Cliente;
import modelo.excepciones.NotContained;
import vista.InterrogaVista;

import java.time.LocalDateTime;


public class Manejo implements Controlador {

    private InterrogaVista vista;
    private CambioModelo modelo;


    public void setModelo(CambioModelo modelo) {
        this.modelo = modelo;
    }


    public void setVista(InterrogaVista vista) {
        this.vista = vista;
    }

    public void abreMostrar() {
        vista.abreMostrar();
    }

    @Override
    public void buscaCliente(String dni) {
        try {
            vista.muestraCliente(modelo.getCliente(dni));
        } catch (NotContained notContained) {
            vista.noEnc();
        }

    }

    @Override
    public void muestraClientes() {
        modelo.getClientes();
    }

    @Override
    public void atrasMostrar() {
        vista.cierraMostrar();
    }

    @Override
    public void abreOps() {
        vista.abreOps();
    }

    @Override
    public void abreCliente() {
        vista.abreCliente();
    }

    @Override
    public void atrasOpCli() {
        vista.cierraOpCli();
    }

    @Override
    public void atrasOp() {
        vista.cierraOp();
    }

    @Override
    public void seleccionaCliente(String text) {
        try {
            vista.selecciona(modelo.getCliente(text));
        } catch (NotContained notContained) {
            vista.noSel();
        }
    }

    @Override
    public void addEmpresa(String nif, String nombre , String email, String cp, String provincia, String poblacion) {
        modelo.creaEmpresa(nif,nombre,email,cp,provincia,poblacion);

    }

    @Override
    public void addParticular(String nif,String nombre,String apellidos,  String email, String cp, String provincia, String poblacion) {
        modelo.creaParticular(nif,nombre,apellidos,email,cp,provincia,poblacion);

    }

    @Override
    public void delCliente(String nif) {
        try {
            vista.borraCliente(modelo.delCliente(nif));
        } catch (NotContained notContained){
            vista.noEnc();
        }
    }

    @Override
    public void setBasica(Cliente seleccionado) {
        modelo.swpTarifa(3,seleccionado);
    }

    @Override
    public void setTardes(Cliente seleccionado) {
        modelo.swpTarifa(2,seleccionado);

    }

    @Override
    public void setDomingos(Cliente seleccionado) {
        modelo.swpTarifa(1,seleccionado);
    }

    @Override
    public void swpPrecio(Cliente seleccionado, double valor) {
        modelo.swpPrecio(seleccionado,valor);
    }

    @Override
    public void listFac(Cliente seleccionado) {
        vista.mostrarFacturas(modelo.getFacturas(seleccionado));
    }

    @Override
    public void addFac(Cliente seleccionado, LocalDateTime now) {
        modelo.emitirFactura(seleccionado,new LocalDateTime[]{now,now.plusMonths(1)});

    }

    @Override
    public void borraFac(int id) {
        vista.borraFac(modelo.delFac(id));
    }

    @Override
    public void buscaFac(int id) {
        vista.muestraFactura(modelo.getFactura(id));
    }

}
