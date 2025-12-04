package BarangayManagementSystem;

import java.util.Scanner;

public class ResidentRegister extends RegisterSystem<Residents, ResidentMenu>{
    
    // private String completeAddress; //in the address we can create an address object here for the user
    // private int age;
    // private String gender;
    // private String fname;
    // private String mname;
    // private String lname;
    // private String contactNumber;
    // private String civilStatus;
    // private String dateOfBirth;


    public void registerUser(Scanner scan, Residents userRegister, String role) {
   processUserInfo(scan, userRegister, role);
   ResidentMenu residentMenu = new ResidentMenu();
   displayUserMenu(scan, userRegister, residentMenu);
    }

    @Override
    public void processUserInfo(Scanner scan, Residents userRegister, String role) {
              super.registerUser(scan, userRegister, role);
        System.out.print("Enter your complete address: ");
        userRegister.setCompleteAddress(scan.nextLine());
        userRegister.setGender(validateGender(scan));
        System.out.print("Enter your First Name: ");
        userRegister.setFname(scan.nextLine());
        System.out.print("Enter your Middle Name: ");
        userRegister.setMname(scan.nextLine());
        System.out.print("Enter your Last Name: ");
        userRegister.setLname(scan.nextLine());
        userRegister.setContactNumber(validateContactNumber(scan));
        userRegister.setCivilStatus(validateCivilStatus(scan));
        userRegister.setDateOfBirth(validateDateOfBirth(scan));
         userRegister.setAge(validateAge(scan, userRegister.getDateOfBirth()));
            saveUser(userRegister);
    }


}
