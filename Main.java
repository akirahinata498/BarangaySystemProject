package BarangayManagementSystem;

import java.util.Scanner;
public class Main {
    public static void main(String[]args) {
        Scanner scan = new Scanner(System.in);
        UsersManager usersManager = UsersManager.getInstance();
        LandingMenu landingMenu = new LandingMenu(usersManager);
        landingMenu.processMenu(scan);
        
    }
}
