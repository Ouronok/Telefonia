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
        boolean exit=false;
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
                    System.out.println("Saliendo del programa");
                    exit=true;
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
        if (cliente != null) {
            return false;
        }
        LinkedList<Factura> list = cliente.getListafac();
        if(list.isEmpty()) return false;
        for (Factura fact : list ) {
            System.out.println(fact.toString());
        }
        return true;
    }

    private boolean getFactura() {
        System.out.println("Escriba el codigo de factura");
        int cod = scanner.nextInt();
        scanner.nextLine();
        Factura factura = app.getFactura(cod);
        if(factura==null){
            return false;
        }
        System.out.println(factura.toString());
        return true;
    }

    private boolean addFactura() {
        cliente = getCliente();
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
        for (Llamada llact : app.getLlamadas(cliente)) {
            System.out.println(llact.toString());
        }
        return true;
    }

    private boolean recClientes() {
        LinkedList<Cliente> list= app.getClientes();
        if(list.isEmpty()){
            return false;
        }
        for (Cliente clact : list) {
            System.out.println(clact.toString());
        }
        return true;
    }

    private boolean recCliente() {
        cliente = getCliente();
        System.out.println(cliente.toString());
        return cliente != null;
    }

    private boolean addLlamada() {
        cliente = getCliente();
        System.out.println("Escribe el telefono llamado");
        String tlf = scanner.nextLine();
        LocalDateTime fecha = LocalDateTime.now();
        System.out.println("Escribe la duracion de la llamada");
        int duracion = scanner.nextInt();
        return app.addLlamada(new Llamada(tlf, duracion, fecha), cliente);
    }


    private Cliente getCliente() {
        System.out.println("Escriba el nif del cliente a recuperar");
        String nif = scanner.nextLine();
        return app.getCliente(nif);
    }

    private boolean addCliente() {
        System.out.println("Desea añadir una empresa o particular? e/p");
        String op = scanner.nextLine();
        String nif;
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
        System.out.println("Escriba su direccion");
        dir = crearDir();
        System.out.println("Escriba el precio de su tarifa");
        precio = scanner.nextDouble();
        scanner.nextLine();
        if (apellidos==null) {
            return app.addCliente(nombre, nif, dir, precio);
        }
        return app.addCliente(nombre, apellidos, nif, dir, precio);
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
        System.out.println("Escriba el nif del cliente a cambiar");
        cliente = app.getCliente(scanner.next());
        System.out.println("Escriba el nuevo precio de la tarifa");
        double precio = scanner.nextDouble();
        return app.swpTarifa(cliente, precio);
    }

    private boolean delCliente() {
        System.out.println("Escriba el nif del cliente a eliminar");
        cliente = app.getCliente(scanner.next());
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
        System.out.println("    7-Listar llamadas cliente");
        System.out.println("    8-Emitir factura");
        System.out.println("    9-Recuperar factura");
        System.out.println("    10-Recuperar facturas cliente");
        System.out.println("    11-Salir");

    }


    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

    }

    private void resultado(Boolean res){
        if(res){
            System.out.println("Se ha realizado con exito la tarea");
        } else {
            System.out.println("Ha ocurrido un error, vuelva a intentarlo");
        }
        System.out.println("Elija la siguiente opcion: ");
    }


}


