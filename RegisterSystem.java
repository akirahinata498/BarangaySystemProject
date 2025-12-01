package BarangayManagementSystem;
import java.util.Scanner;
public abstract class RegisterSystem<T extends Users, M extends MenuValidation<T>> extends Validations {
  protected UsersManager userManager;

    public RegisterSystem() {
        this.userManager = UsersManager.getInstance();
    }

    public void registerUser(Scanner scan, T userRegister, String role) {
        scan.nextLine();
        System.out.print("Enter your username: ");
        userRegister.setUsername(scan.nextLine());
        userRegister.setEmail(validateEmail(scan)); 
        userRegister.setPassword(validatePassword(scan));
        System.out.print("Enter your district: ");
        userRegister.setDistrict(scan.nextLine());
        userRegister.setRole(role);
    }

    public void saveUser(T registeredUser) {
        userManager.addUser(registeredUser);
    }

    public void displayUserMenu(Scanner scan, T registeredUser,M redirectMenu) {
        redirectMenu.CheckUserAuth(registeredUser);
        redirectMenu.processMenu(scan); 
    }

    // 	public  String userInfoReturn(Users user) {
    //     return "Name=" + user.getUserName() +
    //            ", Password=" + user.getPassword() +
    //            ", Birthday=" + user.getBirthday() +
    //            ", Age=" + user.getAge() +    
    //            ", Email=" + user.getEmail() +
    //            ", Number=" + user.getNumber() +
    //            ", Address=" + user.getAddress() +
    //            ", Gender=" + user.getGender() +
    //            ", Campus=" + user.getCampus();
    // }
	public abstract void processUserInfo(Scanner scan, T userRegister, String role);
}
