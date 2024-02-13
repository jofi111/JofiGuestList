import java.util.Scanner;

public class Main {
    static String[] guests = new String[10];
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        guests[0] = "Hans";
        guests[1] = "Marco";
        guests[2] = "Molly";
        guests[3] = "Ann";
        guests[4] = "Fred";

        do {
            displayGuests();
            displayMenu();

            int option = scanner.nextInt();

            if (option == 1) {
                System.out.println("Name: ");
                String name = scanner.next();
                for (int i = 0; i < guests.length; i++) {
                    if (guests[i] == null) {
                        guests[i] = name;
                        break;
                    }
                }
            } else if (option == 2) {
                System.out.println("Name: ");
                String name = scanner.next();
                for (int i = 0; i < guests.length; i++) {
                    if (guests[i] != null && guests[i].equals(name)) {
                        guests[i] = null;
                        break;
                    }
                }
            } else if (option == 3) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid option. Please choose 1, 2 or 3.");
            }
        } while (true);
    }

    static void displayGuests() {
        System.out.println("_______________________\n- Guests -\n");
        for (int i = 0; i < guests.length; i++) {
            System.out.println(guests[i] == null ? "- -" : guests[i]);
        }
    }
    static void displayMenu() {
        System.out.println("_______________________\n- Menu -\n");
        System.out.println("1 - Add Guest");
        System.out.println("2 - Remove Guest");
        System.out.println("3 - Exit");
        System.out.println("Option: ");
    }
}
