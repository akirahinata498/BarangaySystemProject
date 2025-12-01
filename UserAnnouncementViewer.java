package BarangayManagementSystem;

import java.util.LinkedList;
import java.util.Scanner;

public class UserAnnouncementViewer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    }

    public void viewBarangayAnnouncements(Scanner scan) {
        AnnouncementManager manager = AnnouncementManager.getInstance();
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║     PUBLIC ANNOUNCEMENTS                 ║");
        System.out.println("║     BARANGAY NOTICE BOARD                ║");
        System.out.println("╚══════════════════════════════════════════╝");
        
        System.out.println("\nWelcome! Here are the latest announcements from barangay officials.\n");

        boolean running = true;

        while (running) {
            System.out.println("\n=== PUBLIC VIEW MENU ===");
            System.out.println("1. View All Announcements");
            System.out.println("2. View Latest Announcement");
            System.out.println("3. Search Announcement by ID");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = 0;
            try {
                choice = scan.nextInt();
                scan.nextLine(); // Consume newline
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scan.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    viewAllAnnouncements(manager);
                    break;
                    
                case 2:
                    viewLatestAnnouncement(manager);
                    break;
                    
                case 3:
                    searchAnnouncementById(scan, manager);
                    break;
                    
                case 4:
                    running = false;
                    System.out.println("\nThank you for checking barangay announcements!");
                    break;
                    
                default:
                    System.out.println("Invalid option. Please choose 1-4.");
            }
        }
    }
    
    private static void viewAllAnnouncements(AnnouncementManager manager) {

        if (manager.getAllAnnouncements().isEmpty()) {
            System.out.println("\nNo announcements available at the moment.");
            System.out.println("Please check back later.\n");
        } else {
            System.out.println("\n══════════════════════════════════════════");
            System.out.println("        ALL PUBLIC ANNOUNCEMENTS          ");
            System.out.println("══════════════════════════════════════════");
            for (Announcement announcement : manager.getAllAnnouncements()) {
                System.out.println(announcement);
            }
        }
    }
    
    private static void viewLatestAnnouncement(AnnouncementManager manager) {
        
        if (manager.getAllAnnouncements().isEmpty()) {
            System.out.println("\nNo announcements available at the moment.");
        } else {
            System.out.println("\n══════════════════════════════════════════");
            System.out.println("         LATEST ANNOUNCEMENT              ");
            System.out.println("══════════════════════════════════════════");
            manager.displayNewAnnouncement();
        }
    }
    
    private static void searchAnnouncementById(Scanner scanner, AnnouncementManager manager) {
        System.out.print("\nEnter Announcement ID (format: BASD-YYYY-XXXXX): ");
        String searchId = scanner.nextLine();
        
        LinkedList<Announcement> announcements = manager.getAllAnnouncements();
        boolean found = false;
        
        for (Announcement announcement : announcements) {
            if (announcement.getAnnouncementID().equalsIgnoreCase(searchId)) {
                System.out.println("\n══════════════════════════════════════════");
                System.out.println("        ANNOUNCEMENT FOUND                ");
                System.out.println("══════════════════════════════════════════");
                System.out.println(announcement);
                found = true;
                break;
            }
        }
        
        if (!found) {
            System.out.println("\n✗ Announcement with ID '" + searchId + "' not found.");
            System.out.println("Please check the ID and try again.");
        }
    }
}