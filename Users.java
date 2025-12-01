package BarangayManagementSystem;

// import java.security.MessageDigest;
// import java.security.NoSuchAlgorithmException;
// import java.util.LinkedList;


public abstract class Users {
    private String username;
    private String password;
    private String email;
    private String district;
    private String role;
    private UsersManager userManager  = UsersManager.getInstance();
    Users(String username, String password, String email, String district, String role) {
        setUsername(username);
        setPassword(password);
        setEmail(email);
        setDistrict(district);
        setRole(role);
        
    }

    Users() {
    }

    //getters
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return  email;
    }
    public String getDistrict() {
        return district;
    }
    public String getRole() {
        return role;
    }

    //setters
    public void setUsername(String username) {
        this.username=  username;
    }
    public void setPassword(String password) {
        this.password = userManager.hashPassword(password);
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setDistrict(String district) {
        this.district = district;
    }
    public void setRole(String role) {
        this.role = role;
    }

    @Override 
    public String toString() {
        return "Usermmae: " + getUsername() + "\n" +
               "Email: " + getEmail() + "\n" +
               "District: " + getDistrict();  
    }



}
