package by.step.aqa.q1822.final_project.service;

import by.step.aqa.q1822.final_project.controller.AdminMenu;
import by.step.aqa.q1822.final_project.controller.UserMenu;

import java.util.Scanner;

public class ValidationOfLogin {

    AdminMenu adminMenu = new AdminMenu();

    UserMenu userMenu = new UserMenu();

    public void authorizationLogin() {

        ValidationOfPassword validationOfPassword = new ValidationOfPassword("admin", "user");

        System.out.print("Hello! You are on the resource of the Opel car dealer. Please log in system (as \"admin\" or \"user\"), if you want to finish the program write \"exit\": ");
        System.out.println();
        Scanner scan = new Scanner(System.in);
        String autoriz = scan.nextLine();

        if (autoriz.equalsIgnoreCase("user")) {

            validationOfPassword.verifyUserPassword();
            userMenu.startMenu();
            userMenu.generateMenu();
            System.out.println();

        } else if (autoriz.equalsIgnoreCase("admin")) {

            validationOfPassword.verifyAdminPassword();
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
