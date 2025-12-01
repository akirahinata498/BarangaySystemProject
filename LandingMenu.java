package BarangayManagementSystem;
import java.util.InputMismatchException;
import java.util.Scanner;
public class LandingMenu extends BaseMenu{
    private UsersManager usersManager;
    LandingMenu(UsersManager usersManager) {
        this.usersManager = usersManager;
    }
    @Override
    public void displayMenu() {
               System.out.println("****************************************");
        System.out.println(" Welcome to Barangay Management System");
         System.out.println("****************************************");
        System.out.println("1 - Login");
        System.out.println("2 - Register");
        System.out.println("3 - Exit");
    }

    @Override
    public boolean chooseMenu(Scanner scan)  {
     
     
        try {
            int choose = scan.nextInt();
            RegisterMenu registerMenu = new RegisterMenu();
            switch (choose) {
                case 1 -> usersManager.loginUser(scan); 
                case 2 -> registerMenu.processMenu(scan);
                case 3 -> {return false;}
                default -> System.out.println("Please enter only from the choices given");
            }
        }catch(InputMismatchException e) {
            e.printStackTrace();
        }
      return true;
    }


}
