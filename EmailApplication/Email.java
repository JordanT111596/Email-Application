package EmailApplication;

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

    //Constructor to receive the first and last name, department, 
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("\n");
        System.out.println("Hello, " + this.firstName + " " + this.lastName + "!");

        //Calls method asking for the department, then returns the response
        this.department = setDepartment();
        System.out.println("You selected " + this.department);

        //Calls method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        //Combines user data to generate the email address
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix + ".com";
        System.out.println("Your email is: " + email);
    }

    //Asks for the department
    private String setDepartment() {
        //Prints menu
        System.out.println("\n");
        System.out.println("Enter your department number!\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none");
        //Initialize scanner
        Scanner scanner = new Scanner(System.in);
        //Next number entered will be department choice
        int depChoice = scanner.nextInt();
        //If-Else corresponding with department numbers
        if (depChoice == 1) { return "sales"; }
        else if (depChoice == 2) { return "development"; }
        else if (depChoice == 3) { return "accounting"; }
        else { return ""; }
    }

    //Generates a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*-+_";
        char[] password = new char[length];
        //iterates through passwordSet to create a new password
        for (int i = 0; i < length; i++) {
            //random assigns characters to password variable
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //Sets the mailbox capacity with public API
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    //Sets the alternate email with public API
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    //Changes the password with public API
    public void changePassword(String password) {
        this.password = password;
    }

    //Retrieves mailbox capacity with public API
    public int getMailboxCapacity() { return mailboxCapacity; }

    //Retrieves alternate email with public API
    public String getAlternateEmail() { return alternateEmail; }

    //Retrieves password with public API
    public String getPassword() { return password; }
}
