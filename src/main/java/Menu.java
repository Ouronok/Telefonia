/**
 * Created by al342052 on 21/02/2017.
 */

import java.util.Scanner;

public class Menu {




    public static void main(String[] args) {
        Cliente cliente;
        Scanner scanner = new Scanner(System.in);
        Aplicacion app = new Aplicacion();
        menu();
        int op = scanner.nextInt();
        while( op!=11 ) {
            switch (op) {
                case 1:


                    break;
                case 2:
                    System.out.println("Escriba el nif del cliente a eliminar");
                    cliente = app.getCliente(scanner.next());
                    app.delCliente(cliente);
                    break;
                case 3:
                    System.out.println("Escriba el nif del cliente a cambiar");
                    cliente = app.getCliente(scanner.next());
                    System.out.println("Escriba el nuevo precio de la tarifa");
                    double precio = scanner.nextDouble();
                    app.swpTarifa(cliente, precio);
                    break;
                case 4:

                    break;
                default:

            }
            menu();
            op = scanner.nextInt();
        }


    }



    private static void menu() {
        clearScreen();
        System.out.println("Escriba el numero de la opcion para ejecutarla:");
        System.out.println("    1-Dar de alta nuevo cliente");
        System.out.println("    2-Borrar cliente");
        System.out.println("    3-Cambiar tarifa cliente");
        System.out.println("    4-Recuperar cliente");
        System.out.println("    5-Recuperar todos los clientes");
        System.out.println("    6-Dar de alta llamada");
        System.out.println("    7-Listar llamadas clientes");
        System.out.println("    8-Emitir factura");
        System.out.println("    9-Recuperar factura");
        System.out.println("    10-Recuperar facturas cliente");
        System.out.println("    11-Salir");

    }


    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}


