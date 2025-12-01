package BarangayManagementSystem;

import java.util.Scanner;

public class RegisterMenu extends BaseMenu {

    
    @Override
    public void displayMenu() {
       System.out.println("=== Register ===");
       System.out.println("1 - Admin");
       System.out.println("2 - Resident");
       System.out.println("3 - Exit");

    }

    @Override
    public boolean chooseMenu(Scanner scan) {
        int userInputs = scan.nextInt();
         AdminRegister adminRegister = new AdminRegister();
        Admin admin = new Admin();
        ResidentRegister residentRegister = new ResidentRegister();
        Residents residents = new Residents();
        switch (userInputs) {
           case 1 -> adminRegister.registerUser(scan, admin, "Admin");
           case 2 -> residentRegister.registerUser(scan, residents, "Resident");
           case 3 -> {return false;}
           default -> System.out.println("Please enter only from the choices given");
            }
        return true;
    }
}
