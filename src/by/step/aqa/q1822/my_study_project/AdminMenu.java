package by.step.aqa.q1822.my_study_project;

import by.step.aqa.q1822.my_study_project.menu.interfaces.MenuOfAdmin;

import java.io.*;
import java.util.*;

public class AdminMenu implements MenuOfAdmin {

    private Map<Integer, String> menuForAdmin = new HashMap<>();

    private boolean exitFlag = true;

    ListOfCars listOfCars = new ListOfCars();

    @Override
    public void startMenu() {

        AdminMenu adminMenu = new AdminMenu();
        adminMenu.showMenu();
        adminMenu.generateMenu();

        do {
            adminMenu.controllerOfProgram();

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

    private void controllerOfProgram() {

        showMenu();

        int menuPoint = getMenuPoint();

        switch (menuPoint) {
            case (1): {
                addValueInList();
                listOfCars.fileReader();
                System.out.println();
                break;
            }
            case (2): {
                deleteValueFromList();
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
                changePriceInListOfCars();
                System.out.println("Price changed!");
                listOfCars.fileReader();
                break;

            case (5): {
                exitFlag = false;
                System.out.println("Goodbye.");
                break;
            }
        }
    }

    private List deleteValueFromList() {

        ListOfCars listOfCars = new ListOfCars();

        List<String> autosalonAdmin = listOfCars.fileReader();

        try {
            System.out.print("\nWhich car do you want to remove? ");
            Scanner remove = new Scanner(System.in);
            int howPositionRemove = remove.nextInt();

            autosalonAdmin.remove(howPositionRemove);
            System.out.println(howPositionRemove);
            listOfCars.fileWriter();

            StringBuilder stringAfterChange = new StringBuilder();

            int i;
            for (i = 0; i < autosalonAdmin.size(); i++) {

                String str = autosalonAdmin.get(i);
                String[] arrayOfCars = str.split(", ");
                arrayOfCars[0] = String.valueOf(((autosalonAdmin.size() + i) - autosalonAdmin.size()));

                for (int j = 0; j < arrayOfCars.length; j++) {

                    stringAfterChange.append(arrayOfCars[j]);
                    if (j != arrayOfCars.length - 1) {
                        stringAfterChange.append(", ");

                    }
                }
            }


            autosalonAdmin.set(i, stringAfterChange.toString());
            stringAfterChange = new StringBuilder();

        } catch (IndexOutOfBoundsException e) {
            System.err.println(e.getMessage());
        } catch (NullPointerException ex) {
            System.err.println(ex.getMessage());
        }

        return autosalonAdmin;

    }

    private List addValueInList() {

        ListOfCars listOfCars = new ListOfCars();

        List<String> autosalonAdmin = listOfCars.fileReader();

        try {
            System.out.print("\nWhich car do you want to add? (template: sequence number, name model, type engine, type transmission, price): ");
            Scanner add = new Scanner(System.in);
            String whatAdd = add.nextLine();

            autosalonAdmin.add(whatAdd);
            listOfCars.fileWriter();

            StringBuilder listAfterChange = new StringBuilder();

            for (int i = 0; i < autosalonAdmin.size(); i++) {

                String str = autosalonAdmin.get(i);
                String[] arrayOfCars = str.split(", ");
                arrayOfCars[0] = String.valueOf(((autosalonAdmin.size() + i) + autosalonAdmin.size()));

                for (int j = 0; j < arrayOfCars.length; j++) {

                    listAfterChange.append(arrayOfCars[j]);

                    if (j != arrayOfCars.length - 1) {
                        listAfterChange.append(", ");

                    }
                }

                autosalonAdmin.set(i, listAfterChange.toString());
                listAfterChange = new StringBuilder();
            }
        } catch (NullPointerException exception) {
            System.err.println(exception.getMessage());
        }

        return autosalonAdmin;

    }

    private void changePriceInListOfCars() {

        ListOfCars listOfCars = new ListOfCars();

        List<String> autosalonAdmin = listOfCars.fileReader();

        try {
            System.out.print("\nIn which car do we change the price? ");
            Scanner positionList = new Scanner(System.in);
            int howPositionChange = positionList.nextInt();

            String str = autosalonAdmin.get(howPositionChange);
            String[] array = str.split(", ");
            System.out.print("Input new price: ");
            Scanner price = new Scanner(System.in);
            array[4] = price.nextLine();

            StringBuilder afterChanges = new StringBuilder();

            for (int i = 0; i < array.length; i++) {

                afterChanges.append(array[i]);
                if (i != array.length - 1) {
                    afterChanges.append(", ");

                }
            }

            autosalonAdmin.remove(howPositionChange);
            autosalonAdmin.add(afterChanges.toString());

        } catch (IndexOutOfBoundsException exception) {
            System.err.println(exception.getMessage());
        }


        BufferedWriter bufferedWriter = null;

        try {
            bufferedWriter = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\src\\my_study_project\\resources\\list_of_cars.txt"));
            for (String str : autosalonAdmin
            ) {
                bufferedWriter.write(str);
                bufferedWriter.newLine();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                bufferedWriter.flush();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
