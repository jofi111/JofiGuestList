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
            } else {
                System.out.println("Invalid option. Please choose 1, 2, 3, 4 or 5.");
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
        // Ensure not to overwrite non-null entries.
        String[] testNames = {"Hans Morrison", "Marco Morgan", "Molly Jones", "Ann Hughes", "Fred Astair"};
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
    static void renameGuest() {
        System.out.println("Enter the number of the guest you want to rename: ");
        int number = scanner.nextInt();
        scanner.nextLine(); // Consume the leftover newline
        int index = number - 1;

        if (index >= 0 && index < guests.length && guests[index] != null) {
            System.out.println("Enter new name for " + guests[index] + ": ");
            String newName = scanner.nextLine(); // Read the new name
            guests[index] = newName;
            System.out.println("Guest #" + number + " has been renamed to " + newName);
        } else {
            System.out.println("Invalid guest number.");
        }
    }
}