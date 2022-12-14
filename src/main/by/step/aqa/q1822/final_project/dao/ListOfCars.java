package by.step.aqa.q1822.final_project.dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListOfCars {

    List<String> autosalonList = new ArrayList<>();

    String line;

    public List fileReader() {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\main\\resources\\list_of_cars.txt"));
            while ((line = bufferedReader.readLine()) != null) {
                autosalonList.add(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Oops, file not found: " + e.getMessage());
        } catch (IOException ex) {
            System.err.println("Oops, file not readable: " + ex.getMessage());
        }

        return autosalonList;
    }

    public List fileWriter() {

        BufferedWriter bufferedWriter = null;

        try {
            bufferedWriter = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\src\\main\\resources\\list_of_cars.txt"));

            for (String str1 : autosalonList) {

                bufferedWriter.write(str1);
                bufferedWriter.newLine();

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.flush();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
        return autosalonList;
    }

}