package by.step.aqa.q1822.final_project.controller;

import by.step.aqa.q1822.final_project.dao.ListOfCars;
import by.step.aqa.q1822.final_project.service.ValidationOfLogin;

import java.util.*;

public class AdminMenu implements Menu {

    private Map<Integer, String> menuForAdmin = new HashMap<>();

    private boolean exitFlag = true;

    ListOfCars listOfCars = new ListOfCars();

    @Override
    public void startMenu() {

        AdminMenu adminMenu = new AdminMenu();
        adminMenu.showMenu();
        adminMenu.generateMenu();

        do {
            adminMenu.controllerOfProgram(listOfCars);

        } while (adminMenu.exitFlag);
    }

    @Override
    public void generateMenu() {

        menuForAdmin.put(1, "Add car in list");
        menuForAdmin.put(2, "Delete car from list");
        menuForAdmin.put(3, "Show cars in list");
        menuForAdmin.put(4, "Replace price in list");
        menuForAdmin.put(5, "Exit");

    }

    private void showMenu() {

        for (int i = 1; i < menuForAdmin.size() + 1; i++) {
            System.out.println(i + ". " + menuForAdmin.get(i) + " ");
        }

    }

    private int getMenuPoint() {
        System.out.println("\nInput an item in menu: ");
        return new Scanner(System.in).nextInt();
    }

    private void controllerOfProgram(ListOfCars listOfCars) {

        showMenu();

        ValidationOfLogin validationOfLogin = new ValidationOfLogin();
        DeleteValue deleteValue = new DeleteValue();
        AddValue addValue = new AddValue();
        ChangePrice changePrice = new ChangePrice();

        int menuPoint = getMenuPoint();

        switch (menuPoint) {
            case (1): {
                addValue.addValueInList();
                listOfCars.fileReader();
                System.out.println();
                break;
            }
            case (2): {
                deleteValue.deleteValueFromList();
                listOfCars.fileReader();
                System.out.println();
                break;
            }
            case (3): {
                listOfCars.fileReader();
                System.out.println();
                break;
            }
            case (4):
                changePrice.changePriceInListOfCars();
                System.out.println("Price changed!");
                listOfCars.fileReader();
                break;

            case (5): {
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
