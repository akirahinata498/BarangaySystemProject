package BarangayManagementSystem;
import java.util.Scanner;

import java.time.LocalDate;
import java.util.LinkedList;
public class AnnouncementManager {
    private LinkedList<Announcement> announcementRecord = new LinkedList<>();
    private static AnnouncementManager single_instance = null;
     private LocalDate today = LocalDate.now();
      private int year = today.getYear();

	  	

        public void addAnnouncement(Scanner scan, String postedBy) {
			scan.nextLine();
            String announcementID = "BASD-" + year + "-" + String.format("%05d", newCountedAnnouncement()); 
            System.out.print("Enter Announcement Title: ");
            String announcementTitle = scan.nextLine();
            System.out.print("Enter Announcement Content: ");
            String announcementContent = scan.nextLine();
            System.out.print("Enter Announcement Reason: ");
            String announcementReason = scan.nextLine();
            System.out.print("Enter Announcement Conclusion: ");
            String announcementConclusion = scan.nextLine();
            Announcement announcement = new Announcement(announcementID, announcementContent, announcementTitle, postedBy, announcementReason, announcementConclusion);
            announcementRecord.add(announcement);
        }

        public void deleteAnnouncement(Scanner scan) {
			scan.nextLine();
			System.out.print("Enter the announcement id that you want to delete: ");
			String deleteID = scan.nextLine();
			for (Announcement announcement : getAllAnnouncements()) {
				if (deleteID.equals(announcement.getAnnouncementID())) {
					getAllAnnouncements().remove(announcement);
					System.out.println("Announcement Deleted Successfully");
					break;
				}
			}
        }

        public void displayAllAnnouncement() {
			for (Announcement announcement : getAllAnnouncements()) {
				
				System.out.println(announcement + "\n");
			}
        }

        public void displayNewAnnouncement() {
			if (!getAllAnnouncements().isEmpty()) {
				System.out.println(getAllAnnouncements().getLast());
			}
			else {
				System.out.println("No Announcements Yet.");
			}
        }

        public void editAnnouncement(Scanner scan) {
			scan.nextLine();
        
				Announcement announcement = findAnnouncement(scan);
				if (announcement == null) {
					System.out.println("Invalid Input, Announcement ID does not Exist.");
					return;
				}
				System.out.println("=== Edit Announcement");
				System.out.println("1 - Announcement Title");
				System.out.println("2 - Announcement Content");
				System.out.println("3 - Announcement Reason");
				System.out.println("4 - Announcement Conclusion");
				System.out.println("5 - Exit");
				int choose = scan.nextInt();
				scan.nextLine();
				switch (choose) {
					case 1 :
						System.out.print("Edit Announcement Title: ");
						String editAnnouncementTitle = scan.nextLine();
						announcement.setAnnouncementTitle(editAnnouncementTitle);
						break;
					case 2 :
						System.out.print("Edit Announcement Content: ");
						String editAnnouncementContent = scan.nextLine();
						announcement.setAnnouncementContent(editAnnouncementContent);
						break;
					case 3 :
						System.out.print("Edit Announcement Reason: ");
						String editAnnouncementReason = scan.nextLine();
						announcement.setAnnouncementReason(editAnnouncementReason);
						break;
					case 4 :
						System.out.print("Edit Announcement Conclusion: ");
						String editAnnouncementConclusion = scan.nextLine();
						announcement.setAnnouncementConclusion(editAnnouncementConclusion);
						break;
					case 5 :
						
						break;
					default :
						System.out.println("Invalid Input, Please only from the choices given.");
						break;
				}
			
        }


        public int newCountedAnnouncement() {
            int totalAnnouncements = 0;
            for (Announcement announcement : getAllAnnouncements()) {
             totalAnnouncements++;   
            }
            totalAnnouncements++;
            return totalAnnouncements;
        }

		public Announcement findAnnouncement (Scanner scan) {
			System.out.print("Enter the Announcement ID: ");
			String findAnnouncement = scan.nextLine();
			for (Announcement announcement : getAllAnnouncements()) {
				if (findAnnouncement.equals(announcement.getAnnouncementID())) {
					return announcement;
				}
			}
			return null;
		}

    public static synchronized AnnouncementManager getInstance() {
        if (single_instance == null) {
            single_instance = new AnnouncementManager();
        }
        return single_instance;
    }

    public LinkedList<Announcement> getAllAnnouncements() {
        return announcementRecord;
    }



}
