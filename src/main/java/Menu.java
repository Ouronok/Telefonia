/**
 * Created by al342052 on 21/02/2017.
 */

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Aplicacion app = new Aplicacion();
        Scanner scanner = new Scanner(System.in);
        int op = scanner.nextInt();
        while( op!=9 ) {
            switch (op) {
                case 1:
                    System.out.print("Testing");
                    break;
                case 2:
                    System.out.print("\033[H\033[2J");
                    break;
                case 3:
                    // Perform "decrypt number" case.
                    break;
                case 4:
                    // Perform "quit" case.
                    break;
                default:

            }
            op = scanner.nextInt();
        }
        System.out.print("Fin");

    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}


