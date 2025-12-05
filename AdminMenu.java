package BarangayManagementSystem;

import java.util.Scanner;

public class AdminMenu extends BaseMenu implements MenuValidation<Admin>{
    private UsersManager usersManager;
    private Admin userInfo;
    private boolean userValidation;
    private UserAccountManagement userManagement;
    private PayrollRecord payrollRecord;
    private MaintenanceRecord maintenanceRecord;
    private ProcurementRecord procurementRecord;
    private AnnouncementManager announcementManager;
        private SystemLogsManager logsManager = new SystemLogsManager();
    private SystemSettingsManager settingsManager = new SystemSettingsManager();
    private IncidentManager incidentManager;
    private CertificateManager certificateMananager;
    private ReportRecordManager reportRecordManager;
    AdminMenu() {
        this.usersManager = UsersManager.getInstance();
        this.userManagement = new UserAccountManagement();
        this.payrollRecord = new PayrollRecord();
        this.maintenanceRecord = new MaintenanceRecord();
        this.procurementRecord = new ProcurementRecord();
        this.certificateMananager = new CertificateManager();
        this.incidentManager = new IncidentManager();
        this.announcementManager = AnnouncementManager.getInstance();
        this.reportRecordManager = new ReportRecordManager();
    }
    @Override
    public void displayMenu() {
           System.out.println("=== Welcome " + userInfo.getUsername() + " ===");
            System.out.println("1 - Certificate Management");
            System.out.println("2 - Announcement Management");
            System.out.println("3 - Incident Report Management");
            System.out.println("4 - User & Account Management");
            System.out.println("5 - System Logs");
            System.out.println("6 - System Settings");
            System.out.println("7 - Financial Reports");
            System.out.println("8 - Logout");
    }

    @Override
    public boolean chooseMenu(Scanner scan) {
      int userData = scan.nextInt();
      switch (userData) {
        case 1 -> certificateMananager.adminCertificateManagement(scan);
        case 2 -> displayAnnouncementMenu(scan);
        case 3 -> incidentManager.incidentReportMenu(scan);
        case 4 -> userManagement.chooseUserToManage(scan);
        case 5 -> systemLogsMenu(scan);
        case 6 -> systemSettingsMenu(scan);
        case 7 -> ManageFinancialRecording(scan);
        case 8 -> {return isuserLogout(scan);}
        default -> System.out.println("Please enter a proper input");
      }
      return true;
    }

    @Override
    public void processMenu(Scanner scan) {
        boolean isRunning = true;
        while(isRunning) {
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
    public void CheckUserAuth(Admin userCheck) {
    
        for (Users users : usersManager.getAllUsers()) {
            if (userCheck.getUsername().equals(users.getUsername()) && userCheck.getPassword().equals(users.getPassword())) {
                 setUserValidation(true);
                setUserInfo((Admin) users);
            }
        }
    }

    private void ManageFinancialRecording(Scanner scan) {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("=== Enter Record ===");
            System.out.println("1 - Payroll Record");
            System.out.println("2 - Maintenance Record");
            System.out.println("3 - Procurement Record");
            System.out.println("4 - See Citizen Reports");
            System.out.println("5 - Exit");
            int chooseRecprd = scan.nextInt();
            switch (chooseRecprd) {
                case 1 -> payrollRecord.chooseActions(scan, "Payroll");
                case 2 -> maintenanceRecord.chooseActions(scan, "Maintenance");
                case 3 -> procurementRecord.chooseActions(scan, "Procurement");
                case 4 -> reportRecordManager.ManageReport(scan);
                case 5 -> isRunning = false;
                default -> System.out.println("Invalid Input, Please enter a proper input");
            }   
        }
    }

    @Override
    public void setUserInfo(Admin userInfo) {
        this.userInfo = userInfo;
    }
    @Override
    public Admin getUserInfo() {
      return userInfo;
    }
    public boolean isUserValidated() {
        return userValidation;
    }
    public void setUserValidation(boolean userValidation) {
        this.userValidation = userValidation;
    }
    @Override
    public boolean CheckUserAuth(String username, String password) {
      
        for (Users users : usersManager.getAllUsers()) {
            if (users.getUsername().equals(username) && users.getPassword().equals(password)) {
                setUserInfo((Admin) users);
                setUserValidation(true);
                return true;
            }
        }
        return false;
    }

    private void displayAnnouncementMenu(Scanner scan) {
        boolean isRunning = true;
        while (isRunning) {
        System.out.println("===== Announcement Management =====");
        System.out.println("1 - Add Announcement");
        System.out.println("2 - Edit Announcement");
        System.out.println("3 - Delete Announcement");
        System.out.println("4 - Display New Announcement");
        System.out.println("5 - Display All Announcement");
        System.out.println("6 - Exit");
        int choose = scan.nextInt();
        switch (choose) {
            case 1 -> announcementManager.addAnnouncement(scan, userInfo.getUsername());
            case 2 -> announcementManager.editAnnouncement(scan);
            case 3 -> announcementManager.deleteAnnouncement(scan);
            case 4 -> announcementManager.displayNewAnnouncement();
            case 5 -> announcementManager.displayAllAnnouncement();
            case 6 -> isRunning = false;
            default -> System.out.println("Invalid Input, Please enter only from the choices given.");
        }   
        }
    }

    
       private void systemLogsMenu(Scanner scan) {
        int choice;
        do {
            System.out.println("\n=== SYSTEM LOGS MENU ===");
            System.out.println("1. View Login History");
            System.out.println("2. View Activity Logs");
            System.out.println("3. Back");
            System.out.print("Enter choice: ");
            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    logsManager.viewLoginHistory();
                    break;
                case 2:
                    logsManager.viewActivityLogs();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 3);
    }
    


        private void systemSettingsMenu(Scanner scan) {
        int choice;
        do {
            System.out.println("\n=== SYSTEM SETTINGS MENU ===");
            System.out.println("1. View Barangay Information");
            System.out.println("2. Update Barangay Information");
            System.out.println("3. Backup System");
            System.out.println("4. Restore System");
            System.out.println("5. Back");
            System.out.print("Enter choice: ");
            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    settingsManager.viewBarangayInformation();
                    break;
                case 2:
                    settingsManager.updateBarangayInformation(scan);
                    break;
                case 3:
                    settingsManager.backupSystem();
                    break;
                case 4:
                    settingsManager.restoreSystem();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }




}
