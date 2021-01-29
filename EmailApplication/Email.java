package EmailApplication;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private int mailboxCapacity;
    private int defaultPasswordLength = 10;
    private String alternateEmail;

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
        if (depChoice == 1) { return "Sales"; }
        else if (depChoice == 2) { return "Development"; }
        else if (depChoice == 3) { return "Accounting"; }
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

    //Sets the alternate email

    //Changes the password
}
