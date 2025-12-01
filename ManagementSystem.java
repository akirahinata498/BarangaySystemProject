package BarangayManagementSystem;

	import java.util.Scanner;

	public class ManagementSystem {

	    // Method to display the main menu
	    public static void displayMenu() {
	        System.out.println("===== Management System =====");
	        System.out.println("1. Certificate Management");
	        System.out.println("2. Announcement Management");
	        System.out.println("3. Exit");
	        System.out.print("Enter your choice: ");
	    }

	    // Method for Certificate Management
	    public static void CertificateManagement() {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("\n===== Certificate Management =====");
	        System.out.println("1. View All Requests");
	        System.out.println("2. Approve / Reject Requests");
	        System.out.println("3. Generate Certificates");
	        System.out.print("Enter your choice: ");
	        int choice = sc.nextInt();

	        switch (choice) {
	            case 1:
	                System.out.println("Viewing all certificate requests...");
	                break;
	            case 2:
	                System.out.println("Approving or rejecting certificate requests...");
	                break;
	            case 3:
	                System.out.println("Generating certificates...");
	                break;
	            default:
	                System.out.println("Invalid choice. Please try again.");
	        }
	    }

	    // Method for Announcement Management
	    public static void AnnouncementManagement() {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("\n===== Announcement Management =====");
	        System.out.println("1. Post New Announcement");
	        System.out.println("2. Edit / Delete Announcement");
	        System.out.print("Enter your choice: ");
	        int choice = sc.nextInt();

	        switch (choice) {
	            case 1:
	                System.out.println("Posting a new announcement...");
	                break;
	            case 2:
	                System.out.println("Editing or deleting an announcement...");
	                break;
	            default:
	                System.out.println("Invalid choice. Please try again.");
	        }
	    }

	    // Main method to control the flow of the program
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        boolean running = true;

	        while (running) {
	            displayMenu();
	            int choice = sc.nextInt();

	            switch (choice) {
	                case 1:
	                    CertificateManagement();
	                    break;
	                case 2:
	                    AnnouncementManagement();
	                    break;
	                case 3:
	                    System.out.println("Exiting the system...");
	                    running = false;
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }

	        sc.close();
	    }
	}

    