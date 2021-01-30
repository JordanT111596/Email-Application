package EmailApplication;

import java.util.Scanner;

public class EmailApplication {
    public static void main(String[] args) {

        System.out.println("\n");

        String firstName = setFirstName();

        String lastName = setLastName();

        Email user1 = new Email(firstName, lastName);

        System.out.println(user1.showInfo());
    }

    // Asks for first name from user
    public static String setFirstName() {
        // Asks user to enter a name
        System.out.println("Please enter your first name");
        // Initialize scanner
        Scanner userScanner = new Scanner(System.in);
        // Next string entered will be the first name
        String fName = userScanner.next();
        userScanner.close();
        // returns the first name
        return fName;
    }

    // Asks for last name from user
    public static String setLastName() {
        // Asks user to enter a name
        System.out.println("Please enter your last name");
        // Initialize scanner
        Scanner userScanner = new Scanner(System.in);
        // Next string entered will be the last name
        String lName = userScanner.next();
        userScanner.close();
        // returns the last name
        return lName;
    }
}