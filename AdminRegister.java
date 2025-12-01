package BarangayManagementSystem;

import java.util.Scanner;

public class AdminRegister extends RegisterSystem<Admin, AdminMenu>{

        @Override
        public void registerUser(Scanner scan, Admin userRegister, String role) {
            processUserInfo(scan, userRegister, role);
            AdminMenu adminMenu = new AdminMenu();
            displayUserMenu(scan, userRegister, adminMenu);
    }


    @Override
    public void processUserInfo(Scanner scan, Admin userRegister, String role) {
        super.registerUser(scan, userRegister, role);
            userRegister.setAccessLevel("Admin");
            saveUser(userRegister);
    }

}
