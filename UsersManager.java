package BarangayManagementSystem;

import java.lang.classfile.instruction.ReturnInstruction;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.Scanner;
public class UsersManager {
    
    private LinkedList<Users> usersData = new LinkedList<>();
    private static UsersManager single_instance = null;


    public void loginUser(Scanner scan) {
        scan.nextLine();
       
        boolean isLogin = false;
    
        System.out.println("=== Login ===");
        System.out.print("Enter your Username: ");
        String username = scan.nextLine();
        System.out.print("Enter your Password: ");
        String password = hashPassword(scan.nextLine());
        
        for (Users users : getAllUsers()) {
            if (username.equals(users.getUsername()) && password.equals(users.getPassword())) {
                System.out.println("Login Success");
                
                System.out.println("The role are " + users.getRole());
                if (users.getRole().equals("Resident")) {
                ResidentMenu residentMenu = new ResidentMenu();
                    residentMenu.CheckUserAuth(username, password);
                    residentMenu.processMenu(scan);
                }
                else if (users.getRole().equals("Admin")) {
                    AdminMenu adminMenu = new AdminMenu();
                     adminMenu.CheckUserAuth(username, password);
                    adminMenu.processMenu(scan);
                }
                break;
            }
            }

            if (!isLogin) {
                System.out.println("Login Failed, Please try again");
            }

        
    } 
    public void addUser(Users userRegister) {
        usersData.add(userRegister);
    }

    public void deleteProfile(Scanner scan, String role) {
        // scan.nextLine();
        Users userDelete = chooseUserInfo(scan, role);
        if (userDelete == null) {
            System.out.println("User does not exist");
            return;
        }
        usersData.remove(userDelete);
    }

    public void editProfile(Scanner scan, String role, Users userPassed) {
        // scan.nextLine();
        boolean isRunning = true;
        // chooseUserInfo(scan, role)
        Users userEdit = userPassed;
        if (userEdit == null) {
            System.out.println("User does not exist");
            return;
        }
        Validations validation = new Validations();
        System.out.println((userEdit instanceof Residents resident) ? resident : "test");
        while (isRunning) {
            System.out.println("Enter the option that you want to edit");
            System.out.println("1 - Edit Username");
            System.out.println("2 - Edit Password");
            System.out.println("3 - Edit Email");
            System.out.println("4 - Edit District");
            if (userEdit instanceof Residents) {
            System.out.println("5 - Edit Complete Address");
            System.out.println("6 - Edit First Name");
            System.out.println("7 - Edit Middle Name");
            System.out.println("8 - Edit Last Name");
            System.out.println("9 - Edit Contact Number");
            System.out.println("10 - Edit Civil Status");
            System.out.println("11 - Edit Date of Birth");
            }
            System.out.println("0 - Exit");
            int choose = scan.nextInt();
            scan.nextLine();
            switch (choose) {
                case 1 :
                    System.out.print("Edit your Username: ");
                    userEdit.setUsername(scan.nextLine());
                    System.out.println("Username is edited");
                    break;
                case 2 :
                    System.out.print("Edit your Password: ");
                    userEdit.setUsername(validation.validatePassword(scan));
                    System.out.println("Password is edited");
                    break;
                case 3 :
                    System.out.print("Edit your Email: ");
                    userEdit.setEmail(validation.validateEmail(scan));
                    System.out.println("Email is edited");
                    break;
                case 4 : 
                    System.out.print("Edit your District: ");
                    userEdit.setDistrict(scan.nextLine());
                    System.out.println("District is edited");
                    break;
                case 0 : 
                    isRunning = false;
                    break;
            }
               
      if (userEdit instanceof Residents resident) {
    if (choose >= 5 && choose <= 11) {
        switch (choose) {
            case 5 -> {
                System.out.print("Edit your Complete Address: ");
                resident.setCompleteAddress(scan.nextLine());
            }
            case 6 -> {
                System.out.print("Edit your First Name: ");
                resident.setFname(scan.nextLine());
            }
            case 7 -> {
                System.out.print("Edit your Middle Name: ");
                resident.setMname(scan.nextLine());
            }
            case 8 -> {
                System.out.print("Edit your Last Name: ");
                resident.setLname(scan.nextLine());
            }
            case 9 ->  resident.setContactNumber(validation.validateContactNumber(scan));
            case 10 ->  resident.setCivilStatus(validation.validateCivilStatus(scan));
            case 11 -> {
                resident.setDateOfBirth(validation.validateDateOfBirth(scan));
                resident.setAge(validation.validateAge(scan, resident.getDateOfBirth()));
            }
        }
    } 

}
        }
    }


            public Users chooseUserInfo(Scanner scan, String role) {
        //    scan.nextLine();
                System.out.println("Enter the username of user that you want to manage");
                String username = scan.nextLine();
                for (Users users : getAllUsers()) {
                    if (users.getRole().equals(role) && users.getUsername().equals(username)) {
                    return users;
                    }
                }
           return null;
        }


    public static synchronized UsersManager getInstance() {
        if (single_instance == null) {
            single_instance = new UsersManager();
        }
        return single_instance;
    }

    public LinkedList<Users> getAllUsers() {
        return usersData;
    }
        public String hashPassword(String password) { 
        		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] encodedhash = digest.digest(password.getBytes());
			StringBuilder hexstring = new StringBuilder();
			for (byte b : encodedhash) {
				String hex = Integer.toHexString(0xff & b);
				if (hex.length() == 1 ) hexstring.append('0');
				hexstring.append(hex);
			}
			return hexstring.toString();
		}catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Error: SHA-256 Algorithm not found", e);
		}
    }
}
