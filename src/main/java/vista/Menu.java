package vista;

import controlador.Aplicacion;
import modelo.Cliente;
import modelo.BadPeriod;
import modelo.NotContained;
import modelo.NotCreated;
import modelo.Factura;
import modelo.Llamada;

import java.io.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Scanner;

class Menu {

    private Scanner scanner = new Scanner(System.in);
    private Aplicacion app;


    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.menu();
    }

    private void menu() {
        init();
        int op = scanner.nextInt();
        scanner.nextLine();
        printBar();
        boolean exit = false;
        do {
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
                    break;
                case 12:
                    resultado(getLlamadasCliente());
                    break;
                case 13:
                    resultado(getFacturasCliente());
                    break;
                case 14:
                    resultado(swpPrecio());
                    break;
                case 15:
                    System.out.println("Saliendo del programa");
                    save();
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
        }while(!exit);
    }

    private void init(){
        try {
            load();
        } catch (Exception e) {
            app = new Aplicacion();
            System.out.println("Se ha inicializado la aplicacion por primera vez");
        }
        wrtMenu();
    }

    private void load() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("app.bin");
        ObjectInputStream ois = new ObjectInputStream(fis);
        app = (Aplicacion)ois.readObject();
        ois.close();
        System.out.println("Se ha cargado con exito el programa");
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
        Factura factura;
        try{
            factura = app.getFactura(cod);
        } catch(NotCreated e){
            return false;
        }
        System.out.println(factura.toString());
        return true;
    }

    private boolean addFactura() {
        Cliente cliente = getCliente();
        if(cliente==null){
          return false;
        }
        LocalDateTime[] intervalo = new LocalDateTime[2];
        intervalo[1] = LocalDateTime.now();
        intervalo[0] = LocalDateTime.now().minusMonths(1);
        try{
            app.emitirFactura(cliente, intervalo);
        } catch (BadPeriod | NotContained e){
            return false;
        }
        return true;
    }

    private boolean getLlamadas() {
        Cliente cliente = getCliente();
        if (cliente == null) {
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
        Cliente cliente = getCliente();
        if (cliente == null){
            System.out.println("No existe dicho cliente");
            return false;
        }
        System.out.println(cliente.toString());
        return true;
    }

    private boolean addLlamada() {
        Cliente cliente = getCliente();
        if(cliente==null){
            return false;
        }
        System.out.println("Escribe el telefono llamado");
        String tlf = scanner.nextLine();
        LocalDateTime fecha = LocalDateTime.now();
        System.out.println("Escribe la duracion de la llamada");
        int duracion = scanner.nextInt();
        return app.addLlamada(tlf,duracion,fecha,cliente);
    }


    private Cliente getCliente() {
        Cliente cliente;
        System.out.println("Escriba el nif del cliente a realizar la operacion");
        String nif = scanner.nextLine();
        try{
            cliente = app.getCliente(nif);
        } catch (NotContained e) {
            System.out.println(e.getMessage());
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
        String[] dir;
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

    private String[] crearDir() {
        String cp;
        String provincia;
        String poblacion;
        System.out.println("Escriba el codigo postal");
        cp = scanner.nextLine();
        System.out.println("Escriba la provincia");
        provincia = scanner.nextLine();
        System.out.println("Escriba la poblacion");
        poblacion = scanner.nextLine();
        String[] ret = {cp, provincia, poblacion};
        return ret;
    }

    private boolean swpPrecio() {
        Cliente cliente = getCliente();
        System.out.println("Escriba el nuevo precio de la tarifa");
        double precio = scanner.nextDouble();
        return app.swpPrecio(cliente, precio);
    }

    private boolean swpTarifa() {
        Cliente cliente = getCliente();
        System.out.println("Elija la tarifa a aplicar: ");
        System.out.println(" 1-Domingos");
        System.out.println(" 2-Tardes");
        int op = scanner.nextInt();
        return app.swpTarifa(op,cliente);
    }

    private boolean delCliente() {
        Cliente cliente = getCliente();
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
        System.out.println("    7-Listar todas las llamadas del cliente");
        System.out.println("    8-Emitir factura");
        System.out.println("    9-Recuperar factura");
        System.out.println("    10-Recuperar facturas cliente");
        System.out.println("    11-Listar clientes entre fechas");
        System.out.println("    12-Listar llamadas cliente entre fechas");
        System.out.println("    13-Listar facturas cliente entre fechas");
        System.out.println("    14-Cambiar precio tarifa basica");
        System.out.println("    15-Salir");
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
            System.out.println(element.toString());
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
        LinkedList<Cliente> list;
        try{
            list = app.getList(app.getClientes(),fecha1,fecha2);
        } catch (BadPeriod e) {
            return false;
        }

        return printList(list);
    }

    private boolean getLlamadasCliente(){

        LocalDateTime fecha1;
        LocalDateTime fecha2;
        Cliente cliente = getCliente();
        if(cliente==null){
            return false;
        }
        System.out.println("Introduce las fecha de inicio");
        fecha1 = crearFecha();
        System.out.println("Introduce la fecha final");
        fecha2 = crearFecha();
        LinkedList<Llamada> list;
        try{
            list = app.getList(app.getLlamadas(cliente),fecha1,fecha2);
        } catch (BadPeriod e) {
            return false;
        }

        return printList(list);
    }

    private boolean getFacturasCliente(){

        LocalDateTime fecha1;
        LocalDateTime fecha2;
        Cliente cliente = getCliente();
        if(cliente==null){
            return false;
        }
        System.out.println("Introduce las fecha de inicio");
        fecha1 = crearFecha();
        System.out.println("Introduce la fecha final");
        fecha2 = crearFecha();
        LinkedList<Factura> list;
        try{
            list = app.getList(app.getFacturas(cliente),fecha1,fecha2);
        } catch (BadPeriod e) {
            System.out.println(e.getMessage());
            return false;
        }

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
    private void save(){
        try{
            PrintWriter writer = new PrintWriter("app.bin", "UTF-8");
            FileOutputStream fos = new FileOutputStream("app.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(app);
            oos.close();
            writer.close();
            System.out.println("Se ha guardado con exito");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al guardar");
        }

    }
}