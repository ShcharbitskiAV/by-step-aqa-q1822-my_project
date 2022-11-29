package by.step.aqa.q1822.final_project.controller;

import by.step.aqa.q1822.final_project.dao.ListOfCars;
import by.step.aqa.q1822.final_project.service.ValidationOfLogin;

import java.util.*;

public class UserMenu implements Menu {

    private Map<Integer, String> menuForUser = new HashMap<>();

    ListOfCars listOfCars = new ListOfCars();
    private boolean exitFlag = true;

    @Override
    public void startMenu() {

        UserMenu userMenu = new UserMenu();
        userMenu.showMenu();
        userMenu.generateMenu();

        do {
            userMenu.controllerOfProgram();

        } while (userMenu.exitFlag);

    }

    @Override
    public void generateMenu() {

        menuForUser.put(1, "Show cars in stock");
        menuForUser.put(2, "Leave phone number so that our specialist will call and advise you");
        menuForUser.put(3, "Choose a car to buy");
        menuForUser.put(4, "Exit");

    }


    int getMenuPoint() {

        System.out.println("\nInput an item in menu: ");
        return new Scanner(System.in).nextInt();

    }

    private void showMenu() {

        for (int i = 1; i < menuForUser.size() + 1; i++) {
            System.out.println(i + ". " + menuForUser.get(i) + " ");
        }
    }

    private void getPhoneNumber() {
        System.out.print("Input your number: ");
        Scanner scan = new Scanner(System.in);
        String phoneNumber = scan.nextLine();
        System.out.println("\nThanks! We'll call you back by this number: " + phoneNumber);
        System.out.println();
    }

    private void controllerOfProgram() {

        BuyCar buyCar = new BuyCar();

        showMenu();

        ValidationOfLogin validationOfLogin = new ValidationOfLogin();

        int menuPoint = getMenuPoint();

        switch (menuPoint) {

            case (1): {
                listOfCars.fileReader();
                System.out.println();
                break;
            }
            case (2): {
                getPhoneNumber();
                break;
            }
            case (3): {
                listOfCars.fileReader();
                System.out.println("\nIf you want to buy car, select a car from the list.");
                buyCar.buyCarUser();
                System.out.println();
                break;
            }
            case (4): {
                exitFlag = false;
                validationOfLogin.authorizationLogin();
                break;
            }
            default: {
                showIncorrectInputMessage();
            }
        }
    }

    private void showIncorrectInputMessage() {
        System.out.println("Incorrect input");
    }
}
