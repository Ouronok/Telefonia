package vista;

import modelo.clientes.Cliente;
import modelo.datos.Factura;
import modelo.datos.Llamada;

import java.util.LinkedList;

/**
 * Created by ouronok on 25/04/17.
 */
public interface InterrogaVista {
    void abreMostrar();

    void cierraMostrar();

    void abreOps();

    void abreCliente();

    void cierraOpCli();

    void cierraOp();

    void muestraCliente(Cliente cliente);

    void selecciona(Cliente cliente);

    void noSel();

    void noEnc();

    void mostrarFacturas(LinkedList<Factura> facturas);

    void muestraFactura(Factura facutra);

    void borraFac(boolean b);

    void borraCliente(Cliente cliente);

    void mostrarLlamadas(LinkedList<Llamada> llamadas);


}
