package by.step.aqa.q1822.final_project.controller;

public class BuyCar {

    UserMenu userMenu = new UserMenu();

    public void buyCarUser() {

        int submenuPoint = userMenu.getMenuPoint();

        switch (submenuPoint) {
            case (0): {
                System.out.println("Congratulations, you buy a new Opel Astra!");
                break;
            }
            case (1): {
                System.out.println("Congratulations, you buy a new Opel Insignia!");
                break;
            }
            case (2): {
                System.out.println("Congratulations, you buy a new Opel Corsa!");
                break;
            }
            case (3): {
                System.out.println("Congratulations, you buy a new Opel Crossland!");
                break;
            }
            case (4): {
                System.out.println("Congratulations, you buy a new Opel Grandland!");
                break;
            }
            default: {
                System.out.println("Good choice!");
            }
        }
    }
}
