import java.util.Scanner;

public class Main {
    static String[] guests = new String[10];
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        do {
            displayGuests();
            displayMenu();
            int option = getOption();

            if (option == 1) {
                addGuest();
            } else if (option == 2) {
                removeGuest();
            } else if (option == 3) {
                System.out.println("Exiting...");
                break;
            } else if (option==4) {
                insertTestNames();
            } else {
                System.out.println("Invalid option. Please choose 1, 2 or 3.");
            }
        } while (true);

    }

    static void displayGuests() {
        System.out.println("_______________________\n- Guests -\n");
        boolean isEmpty = true;
        for (int i = 0; i < guests.length; i++) {
            if (guests[i] != null) {        //netiskne null pozice
            System.out.println((i+1) + ". " + (guests[i]));
            isEmpty = false;
            }
        }
        if (isEmpty) {
            System.out.println("Guest list is empty.");
        }
    }
    static void displayMenu() {
        System.out.println("_______________________\n- Menu -\n");
        System.out.println("1 - Add Guest");
        System.out.println("2 - Remove Guest");
        System.out.println("3 - Exit");
        System.out.println("4 - Insert 5 testing names");
    }
    static int getOption() {
        System.out.println("Option: ");
        int option = scanner.nextInt();
        scanner.nextLine(); //odstrani prebytecne radky
        System.out.println();
        return option;
    }
    static void addGuest() {
        System.out.println("Name: ");
        String name = scanner.next();
        for (int i = 0; i < guests.length; i++) {
            if (guests[i] == null) {
                guests[i] = name;
                break;
            }
        }
    }
    static void removeGuest() {
        System.out.println("Name: ");
        String name = scanner.next();
        for (int i = 0; i < guests.length; i++) {
            if (guests[i] != null && guests[i].equals(name)) {
                //posun jmen za sebe
                for (int j = i; j < guests.length - 1; j++) {
                    guests[j] = guests[j + 1];
                }
                guests[guests.length - 1] = null;
                break;
            }
        }
    }
    static void insertTestNames() {
        guests[0] = "Hans";
        guests[1] = "Marco";
        guests[2] = "Molly";
        guests[3] = "Ann";
        guests[4] = "Fred";
    }
}
