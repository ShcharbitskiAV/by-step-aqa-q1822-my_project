package by.step.aqa.q1822.final_project.controller;

import by.step.aqa.q1822.final_project.dao.ListOfCars;

import java.util.List;
import java.util.Scanner;

public class AddValue {

    public List addValueInList() {

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
}
