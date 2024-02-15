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
                System.out.println("Invalid option. Please choose 1, 2, 3 or 4.");
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
        // Ensure not to overwrite non-null entries.
        String[] testNames = {"Hans", "Marco", "Molly", "Ann", "Fred"};
        int index = 0;
        for (String testName : testNames) {
            while (index < guests.length && guests[index] != null) {
                index++;
            }
            if (index < guests.length) {
                guests[index] = testName;
            } else {
                break; // No more space in the array.
            }
        }
    }
}