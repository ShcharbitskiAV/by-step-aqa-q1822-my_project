package by.step.aqa.q1822.my_study_project;

import java.util.Scanner;

public class Login {

    Password password = new Password("admin", "user");
    AdminMenu adminMenu = new AdminMenu();
    UserMenu userMenu = new UserMenu();

    public void authorizationLogin() {

        System.out.print("\nHello! You are on the resource of the Opel car dealer. Please log in system (as admin or user): ");
        System.out.println();
        Scanner scan = new Scanner(System.in);
        String autoriz = scan.nextLine();

        if (autoriz.equalsIgnoreCase("user")) {

            password.verifyUserPassword();
            userMenu.startMenu();
            userMenu.generateMenu();
            System.out.println();

        } else if (autoriz.equalsIgnoreCase("admin")) {

            password.verifyAdminPassword();
            adminMenu.startMenu();
            adminMenu.generateMenu();
            System.out.println();

        } else {

            System.out.println("\nIncorrect login");
            System.out.println();
            authorizationLogin();

        }

    }
}