package aplicacion;

import clientes.Cliente;
import datos.Direccion;
import pago.Factura;
import pago.Llamada;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Scanner;

class Menu {

    private Scanner scanner = new Scanner(System.in);
    private Aplicacion app = new Aplicacion();
    private Cliente cliente;

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.menu();
    }

    private void menu() {
        wrtMenu();
        int op = scanner.nextInt();
        scanner.nextLine();
        printBar();
        boolean exit = false;
        while (!exit) {
            switch (op) {
                case 1:
                    resultado(addCliente());
                    break;
                case 2:
                    resultado(delCliente());
                    break;
                case 3:
                    resultado(swpTarifa());
                    break;
                case 4:
                    resultado(recCliente());
                    break;
                case 5:
                    resultado(recClientes());
                    break;
                case 6:
                    resultado(addLlamada());
                    break;
                case 7:
                    resultado(getLlamadas());
                    break;
                case 8:
                    resultado(addFactura());
                    break;
                case 9:
                    resultado(getFactura());
                    break;
                case 10:
                    resultado(getFacturas());
                    break;
                case 11:
                    resultado(getListClientes());
                case 12:
                    resultado(getListLlamadas());
                case 13:
                    resultado(getListFacturas());
                case 14:
                    System.out.println("Saliendo del programa");
                    exit = true;
                    break;
                default:
                    clearScreen();
                    System.out.println("Introduzca una opcion valida");

            }
            if (exit) break;
            wrtMenu();
            op = scanner.nextInt();
            scanner.nextLine();
            clearScreen();
        }
    }

    private boolean getFacturas() {
        Cliente cliente = getCliente();
        if (cliente == null) {
            return false;
        }
        LinkedList<Factura> list = app.getFacturas(cliente);
        return printList(list);
    }

    private boolean getFactura() {
        System.out.println("Escriba el codigo de factura");
        int cod = scanner.nextInt();
        scanner.nextLine();
        Factura factura = app.getFactura(cod);
        if (factura == null) {
            System.out.println("No existe una factura con dicho codigo");
            return false;
        }
        System.out.println(factura.toString());
        return true;
    }

    private boolean addFactura() {
        cliente = getCliente();
        if(cliente==null){
            System.out.println("El cliente no existe");
            return false;
        }
        LocalDateTime[] intervalo = new LocalDateTime[2];
        intervalo[1] = LocalDateTime.now();
        intervalo[0] = LocalDateTime.now().minusMonths(1);
        return app.emitirFactura(cliente, intervalo);
    }

    private boolean getLlamadas() {
        Cliente cliente = getCliente();
        if (cliente != null) {
            return false;
        }
        LinkedList<Llamada> llamadas = app.getLlamadas(cliente);
        if (llamadas.isEmpty()) {
            System.out.println("El cliente no posee llamadas");
            return false;
        }
        for (Llamada llact : llamadas) {
            System.out.println(llact.toString());
        }
        return true;
    }

    private boolean recClientes() {
        LinkedList<Cliente> list = app.getClientes();
        return printList(list);
    }

    private void printBar() {
        System.out.println("------------------------");
    }

    private boolean recCliente() {
        cliente = getCliente();
        if (cliente == null){
            System.out.println("No existe dicho cliente");
            return false;
        }
        System.out.println(cliente.toString());
        return true;
    }

    private boolean addLlamada() {
        cliente = getCliente();
        if(cliente==null){
            return false;
        }
        System.out.println("Escribe el telefono llamado");
        String tlf = scanner.nextLine();
        LocalDateTime fecha = LocalDateTime.now();
        System.out.println("Escribe la duracion de la llamada");
        int duracion = scanner.nextInt();
        return app.addLlamada(new Llamada(tlf, duracion, fecha), cliente);
    }


    private Cliente getCliente() {
        System.out.println("Escriba el nif del cliente a realizar la operacion");
        String nif = scanner.nextLine();
        cliente = app.getCliente(nif);
        if (cliente == null) {
            System.out.println("No existe dicho cliente");
            return null;
        }
        return cliente;
    }

    private boolean addCliente() {
        System.out.println("Desea añadir una empresa o particular? e/p");
        String op = scanner.nextLine();
        String nif;
        String email;
        String nombre;
        Direccion dir;
        String apellidos = null;
        double precio;


        while (!(op.equals("e") || op.equals("p"))) {
            System.out.println("Vuelva a escribir una opcion correcta");
            op = scanner.nextLine();
        }
        if (op.equals("p")) {
            System.out.println("Escriba sus apellidos");
            apellidos = scanner.nextLine();
        }
        System.out.println("Escriba su nombre");
        nombre = scanner.nextLine();
        System.out.println("Escriba su nif");
        nif = scanner.nextLine();
        System.out.println("Escriba su email");
        email = scanner.nextLine();
        dir = crearDir();
        System.out.println("Escriba el precio de su tarifa");
        precio = scanner.nextDouble();
        scanner.nextLine();
        if (apellidos == null) {
            return app.addCliente(nombre, nif, email, dir, precio);
        }
        return app.addCliente(nombre, apellidos, nif, email, dir, precio);
    }

    private Direccion crearDir() {
        String cp;
        String provincia;
        String poblacion;
        System.out.println("Escriba el codigo postal");
        cp = scanner.nextLine();
        System.out.println("Escriba la provincia");
        provincia = scanner.nextLine();
        System.out.println("Escriba la poblacion");
        poblacion = scanner.nextLine();
        return new Direccion(cp, provincia, poblacion);
    }

    private boolean swpTarifa() {
        cliente = getCliente();
        System.out.println("Escriba el nuevo precio de la tarifa");
        double precio = scanner.nextDouble();
        return app.swpTarifa(cliente, precio);
    }

    private boolean delCliente() {
        cliente = getCliente();
        return app.delCliente(cliente);
    }


    private void wrtMenu() {
        clearScreen();
        System.out.println("Escriba el numero de la opcion para ejecutarla:");
        System.out.println("    1-Dar de alta nuevo cliente");
        System.out.println("    2-Borrar cliente");
        System.out.println("    3-Cambiar tarifa cliente");
        System.out.println("    4-Recuperar cliente");
        System.out.println("    5-Recuperar todos los clientes");
        System.out.println("    6-Dar de alta llamada");
        System.out.println("    7-Listar llamadas todas las llamadas del cliente");
        System.out.println("    8-Emitir factura");
        System.out.println("    9-Recuperar factura");
        System.out.println("    10-Recuperar facturas cliente");
        System.out.println("    11-Listar clientes entre fechas");
        System.out.println("    12-Listar llamadas cliente entre fechas");
        System.out.println("    13-Listar facturas cliente entre fechas");
        System.out.println("    14-Salir");
        System.out.print("Opcion: ");

    }


    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

    }

    private void resultado(Boolean res) {
        if (res) {
            System.out.println("Se ha realizado con exito la tarea");
        } else {
            System.out.println("Ha ocurrido un error, vuelva a intentarlo");
        }
        System.out.println("Elija la siguiente opcion: ");
    }

    private <T> boolean printList(LinkedList<T> list){
        if (list.isEmpty()) {
            System.out.println("No existen elementos");
            return false;
        }
        for(T element : list){
            element.toString();
            System.out.println("---------");
        }
        return true;
    }

    private boolean getListClientes(){
        LocalDateTime fecha1;
        LocalDateTime fecha2;
        System.out.println("Introduce las fecha de inicio");
        fecha1 = crearFecha();
        System.out.println("Introduce la fecha final");
        fecha2 = crearFecha();
        LinkedList<Cliente> list = app.getList(app.getClientes(),fecha1,fecha2);
        return printList(list);
    }

    private LocalDateTime crearFecha() {
        System.out.println("Dia");
        int dia = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Mes");
        int mes = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Año");
        int año = scanner.nextInt();
        scanner.nextLine();
        return LocalDateTime.of(año,mes,dia,0,0);
    }
}