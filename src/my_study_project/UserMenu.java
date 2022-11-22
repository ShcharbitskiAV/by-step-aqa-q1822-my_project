package my_study_project;

import java.util.*;

public class UserMenu implements MenuOfUser {

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


    private int getMenuPoint() {

        System.out.println("\nInput an item in menu: ");
        return new Scanner(System.in).nextInt();

    }


    private void buyCar() {

        int submenuPoint = getMenuPoint();

        switch (submenuPoint) {
            case (1): {
                System.out.println("Congratulations, you buy a new Opel Astra!");
                break;
            }
            case (2): {
                System.out.println("Congratulations, you buy a new Opel Insignia!");
                break;
            }
            case (3): {
                System.out.println("Congratulations, you buy a new Opel Corsa!");
                break;
            }
            case (4): {
                System.out.println("Congratulations, you buy a new Opel Crossland!");
                break;
            }
            case (5): {
                System.out.println("Congratulations, you buy a new Opel Grandland!");
                break;
            }
        }
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

        showMenu();

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
                buyCar();
                System.out.println();
                break;
            }
            case (4): {
                exitFlag = false;
                System.out.println("Goodbye, have a nice day!");
                break;
            }
            default: {
                System.out.println("Incorrect input");
            }
        }
    }
}
