package EmailApplication;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "jjindustries";

    // Constructor to receive the first and last name, department,
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("\n");
        System.out.println("Hello, " + this.firstName + " " + this.lastName + "!");

        // Calls method asking for the department, then returns the response
        this.department = setDepartment();

        // Calls method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("\nYour randomly generated password is: " + this.password);

        // Combines user data to generate the email address
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix
                + ".com";
    }

    // Asks for the department
    private String setDepartment() {
        String departmentPick = "";
        // Prints menu
        System.out
                .println("Enter your department number!\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none");
        // Initialize scanner
        Scanner deptScanner = new Scanner(System.in);
        boolean deptCheck = false;
        int depChoice;
        while (deptCheck == false) {
            // Next number entered will be department choice
            try {
                depChoice = (int) deptScanner.nextInt();
                switch (depChoice) {
                    // Switch corresponding with department numbers
                    case 0: {
                        deptCheck = true;
                        break;
                    }
                    case 1: {
                        deptCheck = true;
                        departmentPick = "sales";
                        break;
                    }
                    case 2: {
                        deptCheck = true;
                        departmentPick = "development";
                        break;
                    }
                    case 3: {
                        deptCheck = true;
                        departmentPick = "accounting";
                        break;
                    }
                    default: {
                        System.out.println("Please type your corresponding department number!");
                        break;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Please type your corresponding department number!");
                deptScanner.next();
            }
        }

        return departmentPick;
    }

    // Generates a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*-+_";
        char[] password = new char[length];
        // iterates through passwordSet to create a new password
        for (int i = 0; i < length; i++) {
            // random assigns characters to password variable
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // Sets the mailbox capacity with public API
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    // Sets the alternate email with public API
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    // Changes the password with public API
    public void changePassword(String password) {
        this.password = password;
    }

    // Retrieves mailbox capacity with public API
    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    // Retrieves alternate email with public API
    public String getAlternateEmail() {
        return alternateEmail;
    }

    // Retrieves password with public API
    public String getPassword() {
        return password;
    }

    // Shows info requested (display name, company email, and mailbox capacity)
    public String showInfo() {
        return "Your display name is: " + firstName + " " + lastName + "\n" + "Your company email is: " + email + "\n"
                + "Your mailbox capacity is: " + mailboxCapacity + "mb";
    }

    // Changes the first name with public API
    public void setFirstName(String fName) {
        this.firstName = fName;
    }

    // Changes the Last name with public API
    public void setLastName(String lName) {
        this.lastName = lName;
    }

    /*
     * Initializes menu options for viewing info, changing password, setting
     * alternate email, setting mailbox capacity, and changing first and last name
     */
    public void postMenu() {

        int menuChoice = 0;
        Scanner menuScanner = new Scanner(System.in);
        // while the menu choice is not 6 continue with menu choices.
        while (menuChoice != 6) {

            try {
                // Asks user question to begin menu
                System.out.println(
                        "\nWhat would you like to do?\n1. View Info\n2. Change Password\n3. Set Alternate Email\n4. Set Mailbox Capacity\n5. Change display name\n6. Exit");
                // Scanner created to capture user choice via integer input
                menuChoice = menuScanner.nextInt();

                switch (menuChoice) {
                    case 1:
                        // Shows user info before restarting the menu
                        System.out.println(this.showInfo());
                        break;
                    case 2:
                        // Begins process for changing the password with a scanner input, then restarts
                        // menu
                        System.out.println("\nWhat would you like to change your password to?");
                        this.changePassword(menuScanner.next());
                        System.out.println("Change successful! Your password is now " + this.password);
                        break;
                    case 3:
                        // Begins process for changing the alternate email with a scanner input, then
                        // restarts menu
                        System.out.println("\nWhat email would you like to set as your alternate?");
                        this.setAlternateEmail(menuScanner.next());
                        System.out.println("Change successful! Your alternate email is now " + this.alternateEmail);
                        break;
                    case 4:
                        // Begins process for changing the mailbox capacity with a scanner integer
                        // input, then restarts menu
                        System.out.println("\nWhat would you like to change your mailbox capacity to? (in MB)");
                        this.setMailboxCapacity(menuScanner.nextInt());
                        System.out.println("Change successful! Your mailbox capacity is now " + this.mailboxCapacity + "mb");
                        break;
                    case 5:
                        // Begins process for changing the user's first and last name with a scanner
                        // input, then restarts menu
                        System.out.println("\nWhat is your first name?");
                        this.setFirstName(menuScanner.next());
                        System.out.println("Change successful! Your first name is now " + this.firstName);
                        System.out.println("\nWhat is your last name?");
                        this.setLastName(menuScanner.next());
                        System.out.println("Change successful! Your last name is now " + this.lastName);
                        break;
                    case 6:
                        // Closes the program
                        System.out
                                .println("The program is now ending.\nThank you for using Jordan's Email Application!");
                        menuScanner.close();
                        System.exit(0);
                        break;
                    default:
                        // If user enters an unavailable number, a message is displayed and the menu
                        // restarts
                        System.out.println("\nPlease enter a valid integer corresponding with your choice");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please type your corresponding menu choice!");
                menuScanner.next();
            }
        }

    }
}
