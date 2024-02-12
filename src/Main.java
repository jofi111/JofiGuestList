import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


            String[] guests = new String[10];
            Scanner scanner = new Scanner(System.in);

            guests[0]="Hans";
            guests[1]="Marco";
            guests[2]="Molly";
            guests[3]="Ann";
            guests[4]="Fred";

        do {
            System.out.println("_______________________\n- Menu -\n");
            System.out.println("1 - Display All Guests");
            System.out.println("2 - Add Guest");
            System.out.println("3 - Remove Guest");
            System.out.println("4 - Exit");
            System.out.println("Option: ");
            int option = scanner.nextInt();
            System.out.println();

            if (option == 1) {
                System.out.println("_______________________\n- Guests -\n");
                for (int i = 0; i < guests.length; i++) {
                    System.out.println(guests[i]==null ? "- -" : guests[i]);
                }
            }
            else if (option==2) {
                for (int i = 0; i < guests.length; i++) {
                    if (guests[i] == null) {
                        System.out.println("Name: ");
                        guests[i] = scanner.next();
                        break;
                    }
                }
            }
            else if (option==3) {
                System.out.println("Name: ");
                String name= scanner.next();
                for (int i = 0; i < guests.length; i++) {
                    if (guests[i]!=null && guests[i].equals(name)) {
                        guests[i] = null;
                        break;
                    }
                }
            }
            else if (option==4) {
                break;
            }
        } while (true);
        System.out.println("Exiting...");
    }
}