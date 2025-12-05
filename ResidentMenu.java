package BarangayManagementSystem;

import java.net.FileNameMap;
import java.util.Scanner;

public class ResidentMenu extends BaseMenu implements MenuValidation<Residents>{
    private UsersManager usersManager;
    private Residents userInfo;
    private boolean userValidation;
    private IncidentManager incidentManager;
    private CertificateManager certificateRequest;
    private UserAnnouncementViewer userAnnouncementViewer;
    private ReportRecordManager reportRecordManager;
    ResidentMenu() {
        this.usersManager = UsersManager.getInstance();
        incidentManager = new IncidentManager();
        this.certificateRequest = new CertificateManager();
        this.userAnnouncementViewer = new UserAnnouncementViewer();
        this.reportRecordManager = new ReportRecordManager();
    }
    @Override
    public void displayMenu() {
        
        System.out.println("=== Welcome " + userInfo.getUsername() + " ===");
        System.out.println("1 - View Profile");
        System.out.println("2 - Update Profile");
        System.out.println("3 - Request Certificate");
        System.out.println("4 - View my Certificate Request");
        System.out.println("5 - View Barangay Announcemments");
        System.out.println("6 - Submit Incident Report (Blotter)");
        System.out.println("7 - Transparency Record");
        System.out.println("8 - Logout");
    }

    @Override
    public boolean chooseMenu(Scanner scan) {
        int userChoice = scan.nextInt();
        switch (userChoice) {
            case 1 -> System.out.println("=== My Profile ===\n" + userInfo);
            case 2 -> usersManager.editProfile(scan, "Resident", userInfo);
            case 3 -> certificateRequest.newRequest(scan, userInfo.getFname(), userInfo.getMname(), userInfo.getLname());
            case 4 -> certificateRequest.residentViewCertificate(userInfo.getFname(), userInfo.getMname(), userInfo.getLname());
            case 5 -> userAnnouncementViewer.viewBarangayAnnouncements(scan);
            case 6 -> incidentManager.createNewIncident(scan, userInfo.getFname(), userInfo.getLname());
            case 7 -> reportRecordManager.TransparencyRecordMenu(scan, userInfo.getFname(), userInfo.getLname());
            case 8 -> {return isuserLogout(scan);}
            default -> System.out.println("Please enter a proper input");
        }
        return true;
    }

    @Override
    public void processMenu(Scanner scan) {
        boolean isRunning = true;
        while (isRunning) {
        if (isUserValidated() && userInfo != null) {
         displayMenu();
         isRunning = chooseMenu(scan);
       }
       else {
        System.out.println("User is not yet validated");
        isRunning = false;
       }
        }
    }
    
    @Override
    public void setUserInfo(Residents userInfo) {
       this.userInfo = userInfo;
    }
    @Override
    public Residents getUserInfo() {
        return userInfo;
    }
    public boolean isUserValidated() {
        return userValidation;
    }
    public void setUserValidation(boolean userValidation) {
        this.userValidation = userValidation;
    }
    @Override
    public void CheckUserAuth(Residents userCheck) {
        
        for (Users users : usersManager.getAllUsers()) {
            if (userCheck.getUsername().equals(users.getUsername()) && userCheck.getPassword().equals(users.getPassword())) {
                setUserInfo((Residents) users);
                setUserValidation(true);
            }
        }   
    }
    @Override
    public boolean CheckUserAuth(String username, String password) {
        for (Users users : usersManager.getAllUsers()) {
            if (users.getUsername().equals(username) && users.getPassword().equals(password)) {
                setUserInfo((Residents) users);
                setUserValidation(true);
                return true;
            }
        }
        return false;
    }


}
