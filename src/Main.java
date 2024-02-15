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
            } else if (option == 5) {
                renameGuest();
            } else if (option == 6) {
                insertGuestAtPosition();
            } else {
                System.out.println("Invalid option. Please choose between 1 to 6.");
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
        System.out.println("5 - Rename guest");
        System.out.println("6 - Insert Guest at Position");
    }
    static int getOption() {
        System.out.println("Option: ");
        int option = scanner.nextInt();
        scanner.nextLine(); //odstrani prebytecny radek po odenterovani volby (Hitting enter actually produces a newline so “5\n” gets sent as the input. The nextInt() method will read the 5 but will leave the \n. Therefore if you use a nextLine() at some point afterwards, it will immediately read the \n, and the program will continue as though nextLine() was never called.)
        System.out.println();
        return option;
    }
    static void addGuest() {
        System.out.println("Name: ");
        String name = scanner.nextLine(); //umozni zadat jmeno s mezerou
        for (int i = 0; i < guests.length; i++) {
            if (guests[i] == null) {
                guests[i] = name;
                break;
            }
        }
    }
    static void removeGuest() {
        System.out.println("Enter guest number to remove: ");
        int number = scanner.nextInt();
        int index = number-1;

        if (index>=0 && index< guests.length && guests[index] != null) {
            for (int i = index; i < guests.length -1; i++) {
                guests[i] = guests[i + 1];
            }
            guests[guests.length - 1] = null;
        } else {
            System.out.println("Invalid guest number.");
            }
        }
    static void insertTestNames() {
        // neprepsani jiz existujicich jmen
        String[] testNames = {"Hans Morrison", "Marco Morgan", "Molly Jones", "Ann Hughes", "Fred Astair"};
        int index = 0;
        for (String testName : testNames) {
            while (index < guests.length && guests[index] != null) {
                index++;
            }
            if (index < guests.length) {
                guests[index] = testName;
            } else {
                break; // plne pole
            }
        }
    }
    static void renameGuest() {
        System.out.println("Enter the number of the guest you want to rename: ");
        int number = scanner.nextInt();
        scanner.nextLine(); // odstrani nadbytecny radek po enteru
        int index = number - 1;

        if (index >= 0 && index < guests.length && guests[index] != null) {
            System.out.println("Enter new name for " + guests[index] + ": ");
            String newName = scanner.nextLine(); // zadani noveho jmena
            guests[index] = newName;
            System.out.println("Guest #" + number + " has been renamed to " + newName);
        } else {
            System.out.println("Invalid guest number.");
        }
    }
    static void insertGuestAtPosition() {
        System.out.println("Enter the name of the guest to insert: ");
        String name = scanner.nextLine(); // zadani noveho jmena

        System.out.println("Enter the position to insert the guest at: ");
        int position = scanner.nextInt();
        scanner.nextLine(); // odstrani nadbytecny radek po enteru

        int index = position - 1; // zmena zadaneho cisla na index

        // kontrola platne pozice a alespon jedne volne null pozice pro posun
        if (index >= 0 && index < guests.length) {
            // posun jmen v poli k uvolneni pozice pro nove jmeno
            for (int i = guests.length - 1; i > index; i--) {
                guests[i] = guests[i - 1];
            }
            // hlaska
            guests[index] = name;
            System.out.println(name + " has been inserted at position " + position);
        } else {
            System.out.println("Invalid position.");
        }
    }
}