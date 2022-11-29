package by.step.aqa.q1822.final_project.controller;

import by.step.aqa.q1822.final_project.dao.ListOfCars;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ChangePrice {

    public void changePriceInListOfCars() {

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
            bufferedWriter = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\src\\main\\resources\\list_of_cars.txt"));
            for (String str : autosalonAdmin
            ) {
                bufferedWriter.write(str);
                bufferedWriter.newLine();

            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
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
