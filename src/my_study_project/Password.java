package my_study_project;

import java.util.Scanner;

public class Password {

    private String adminPassword;
    private String userPassword;
    Scanner scan = new Scanner(System.in);

    public Password(String adminPassword, String userPassword) {
        this.adminPassword = adminPassword;
        this.userPassword = userPassword;
    }

    public void verifyAdminPassword() {

        System.out.print("\nOk, you are admin. Please, input your password: ");

        adminPassword = scan.nextLine();

        if (adminPassword.equals("admin")) {

            System.out.println("\nCorrect password, you are logged in system");
            System.out.println();
            return;

        } else {

            System.out.println("\nIncorrect password");
            System.out.println();

        }

        verifyAdminPassword();
    }

    public void verifyUserPassword() {

        System.out.print("Ok, you are user. Please, input your password: ");

        userPassword = scan.nextLine();

        if (userPassword.equals("user")) {

            System.out.println("Correct password, you are logged in system");
            System.out.println();
            return;

        } else {

            System.out.println("Incorrect password");

        }

        verifyUserPassword();

    }

}
