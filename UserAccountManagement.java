package BarangayManagementSystem;
import java.util.Scanner;
public class UserAccountManagement {
    

    private AdminRegister adminRegister;
    private ResidentRegister residentRegister;
   
    private UsersManager userManager;
    UserAccountManagement() {
        this.userManager = UsersManager.getInstance();
       
        this.adminRegister = new AdminRegister();
        this.residentRegister = new ResidentRegister();
    }

        public void chooseUserToManage(Scanner scan) {
            boolean isRunning = true;
            while (isRunning) {
           System.out.println("Enter your choice");
           System.out.println("1 - Manage Admin");
           System.out.println("2 - Manage Residents");   
           System.out.println("3 - Exit");
           int choose = scan.nextInt();
           switch (choose) {
            case 1 -> manageAdmin(scan);
            case 2 -> manageResidents(scan);
            case 3 -> isRunning = false;
            default -> System.out.println("Please enter only from the choices given");
           }
            }
        }   
        private void manageAdmin(Scanner scan) {
            boolean isRunning = true;
            while (isRunning) {
            System.out.println("Enter your choice");
            System.out.println("1 - Add Admin");
            System.out.println("2 - Edit Admin");
            System.out.println("3 - Delete Admin");
            System.out.println("4 - View All Admin");
            System.out.println("5 - Exit");   
            int userChoice = scan.nextInt();
                switch (userChoice) {
                    case 1 -> {
                        Admin admin = new Admin();
                        adminRegister.processUserInfo(scan, admin, "Admin");
                    } 
                    case 2 -> userManager.editProfile(scan,  "Admin", userManager.chooseUserInfo(scan, "Admin"));
                    case 3 -> userManager.deleteProfile(scan, "Admin");
                    case 4 -> displayUsers("Admin");
                    case 5 -> isRunning = false;
                    default -> System.out.println("Invalid Input. Please try again");
                }
            }
        }

        private void manageResidents(Scanner scan) {

              boolean isRunning = true;
            while (isRunning) {
               
            System.out.println("Enter your choice");
            System.out.println("1 - Add Residents");
            System.out.println("2 - Edit Residents");
            System.out.println("3 - Delete Residents");
            System.out.println("4 - View All Residents");
            System.out.println("5 - Exit");
            int userChoice = scan.nextInt();
            switch (userChoice) {
                case 1 -> {
                     Residents resident = new Residents();
                     residentRegister.processUserInfo(scan, resident, "Resident");
                }
                case 2 -> userManager.editProfile(scan,  "Resident", userManager.chooseUserInfo(scan, "Resident"));
                case 3 -> userManager.deleteProfile(scan, "Resident");
                case 4 -> displayUsers("Resident");
                case 5 -> isRunning = false;
                default -> System.out.println("Invalid Input. Please try again");
            }
            }
        }

        public void displayUsers(String role) {
            for (Users user : userManager.getAllUsers()) {
                if (user instanceof Residents resident && role.equals(user.getRole())) {
                    System.out.println(resident);
                }
                else if (user instanceof Admin admin && role.equals(user.getRole())) {
                    System.out.println(admin + "\n");
                }
            }
        }


}
