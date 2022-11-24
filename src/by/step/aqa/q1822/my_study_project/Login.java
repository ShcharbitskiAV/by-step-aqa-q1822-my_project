package by.step.aqa.q1822.my_study_project;

import by.step.aqa.q1822.my_study_project.menu.AdminMenu;
import by.step.aqa.q1822.my_study_project.menu.UserMenu;

import java.util.Scanner;

public class Login {

    AdminMenu adminMenu = new AdminMenu();

    UserMenu userMenu = new UserMenu();

    public void authorizationLogin() {

        Password password = new Password("admin", "user");

        System.out.print("Hello! You are on the resource of the Opel car dealer. Please log in system (as \"admin\" or \"user\"), if you want to finish the program write \"exit\": ");
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

        } else if (autoriz.equalsIgnoreCase("exit")) {

            return;

        } else {

            System.out.println("\nIncorrect login");
            System.out.println();
            authorizationLogin();

        }
    }
}
