package by.step.aqa.q1822.final_project.controller;

/*
List of cars before changes:
1, Astra, hybrid, auto, 25000$
2, Insignia, petrol, manual, 35000$
3, Corsa, electric, auto, 30000$
4, Crossland, hybrid, auto, 40000$
5, Grandland, petrol, manual, 43000$

 */


import by.step.aqa.q1822.final_project.service.ValidationOfLogin;

public class Main {

    public static void main(String[] args) {

        ValidationOfLogin validationOfLogin = new ValidationOfLogin();
        validationOfLogin.authorizationLogin();

    }

}
