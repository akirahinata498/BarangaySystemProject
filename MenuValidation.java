package BarangayManagementSystem;

import java.util.Scanner;

public interface MenuValidation<T extends Users> extends Menu {
    void CheckUserAuth(T users);
    boolean CheckUserAuth(String username, String password);
    void setUserInfo(T users);
    T getUserInfo();
    boolean isUserValidated();
    void setUserValidation(boolean userValidation);
    default boolean isuserLogout(Scanner scan) {
        while (true) {
            scan.nextLine();
        System.out.print("Are your sure you want to logout? (Y/N): ");
        String logout = scan.nextLine();
        if (logout.equalsIgnoreCase("Y") || logout.equalsIgnoreCase("Yes")) {
            System.out.println("User Logout Successfully.");
            setUserInfo(null);
            setUserValidation(false);
            return false;
        }
        else if (logout.equalsIgnoreCase("N") || logout.equalsIgnoreCase("No")) {
            return true;
        }
        else {
            System.out.println("Please enter yes or no only");
            continue;
        }
        }
    }
}