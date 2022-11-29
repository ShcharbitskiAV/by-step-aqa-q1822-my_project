package by.step.aqa.q1822.final_project.controller;

import by.step.aqa.q1822.final_project.dao.ListOfCars;

import java.util.List;
import java.util.Scanner;

public class DeleteValue {
    public List deleteValueFromList() {

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
}
