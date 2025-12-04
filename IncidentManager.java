package BarangayManagementSystem;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class IncidentManager {
    private IncidentStorage incidentStorage;
    private ArchieveStorage archieveStorage;
    
    // private static IncidentSearch search = new IncidentSearch();
    private static boolean running = true;
    private LocalDate today = LocalDate.now();
    private int year = today.getYear();
    IncidentManager() {
        this.incidentStorage = IncidentStorage.getInstance();
        this.archieveStorage = ArchieveStorage.getInstance();
    }





    public void displayAllCurrentIncidentReports() {
         if (incidentStorage.getAllIncidents().isEmpty()) {
            System.out.println("No incident records.");
            return;
            }
            System.out.println("\n======== ALL INCIDENT REPORT ========");
        for (IncidentReport report : incidentStorage.getAllIncidents()) {
           System.out.println(report);
        }
        System.out.println("=====================================\n");
    }


    public void displayAllArchieveReports() {
        if (archieveStorage.getAllArchieveIncidents().isEmpty()) {
            System.out.println("No incident records.");
            return;
        }
        System.out.println("\n======== ALL Archieved REPORT ========");
        for (IncidentReport report : archieveStorage.getAllArchieveIncidents()) {
           System.out.println(report);
        }
        System.out.println("=====================================\n");
    }
 

        public void createNewIncident(Scanner scan, String fname, String lname) {
        scan.nextLine();
        String incidentId = "INC-" + year + "-" + String.format("%05d", (incidentStorage.getAllIncidents().size() + 1));
        System.out.print("Enter title: ");
        String title = scan.nextLine();
        System.out.print("Enter description: ");
        String description = scan.nextLine();
        String fullName = fname + " " + lname; 
        String status = "Pending";
        IncidentReport incident = new IncidentReport(incidentId, title, description, fullName, status);
        incidentStorage.addIncident(incident);
        System.out.println("Incident created successfully!");
        System.out.println(incident);
    }

    private IncidentReport searchIncidentById(Scanner scan, String typeOfRecord) {
        System.out.print("Enter Incident ID to search: ");
        String id = scan.nextLine();
        IncidentReport report = (typeOfRecord.equals("CurrentIncident")) ? incidentStorage.findById(id) : archieveStorage.findById(id);
        if (report != null) {
            return report;
        } else {
            System.out.println("No incident found with ID: " + id);
        }
        return null;
    }

    private void searchIncidentsByReporter(Scanner scan, String typeOfRecord) {
        System.out.print("Enter reporter name to search: ");
        String reporterName = scan.nextLine();
        
            List<IncidentReport> foundReports =  (typeOfRecord.equals("CurrentIncident")) ? incidentStorage.findByReporter(reporterName) : archieveStorage.findByReporter(reporterName) ;
        if (foundReports.isEmpty()) {
            System.out.println("No incidents found for reporter: " + reporterName);
        } else {
            System.out.println("\n=== INCIDENTS BY " + reporterName.toUpperCase() + " ===");
            for (IncidentReport report : foundReports) {
                System.out.println(report);
                System.out.println("----------------------");
            }
        }
    }

    	public void viewAllIncidents(List<IncidentReport> incidents) {
		if(incidents.isEmpty()) {
			System.out.println("No incident records.");
			return;
		}
		System.out.println("\n======== ALL INCIDENT REPORT ========");
		
		for(IncidentReport report : incidents){
			System.out.println(report);
		}
		System.out.println("=====================================\n");
	} 



    public void arhieveReports(Scanner scan) {

            System.out.print("Enter the Incident Id that you want to archieve: ");
            String incidentID = scan.nextLine();
            for (IncidentReport incidents : incidentStorage.getAllIncidents()) {
                if (incidentID.equals(incidents.getId())) {
                   if (incidents.getStatus().equals("Pending") || incidents.getStatus().equals("In Progress")) {
                    System.out.println("Cannot still archieve this report as it is still " + incidents.getStatus());
                    break;
                   }
                   else {
                    System.out.println("Report Successfully Archieve.");
                    archieveStorage.addArchieve(incidents);
                    incidentStorage.getAllIncidents().remove(incidents);
                    break;
                   }
                }
        }
    }
    
    public void updateCaseStatus(Scanner scan) {
        int choose;
      do {
            IncidentReport report = searchIncidentById(scan, "CurrentIncident");
            if (report == null) break;
            System.out.println("Current Status: " + report.getStatus());
            System.out.println("Choose New Status: ");
            System.out.println("1 - In Progress");
            System.out.println("2 - Pending");
            System.out.println("3 - Settled");
            System.out.println("4 - Police Intervention");
            System.out.println("5 - Exit");
             choose  = scan.nextInt();
            switch (choose) {
                case 1 -> report.setStatus("In Progress");
                case 2 -> report.setStatus("Pending");
                case 3 -> report.setStatus("Settled");
                case 4 -> report.setStatus("Police Intervention");
                default-> System.out.println("Invalid Input, Please enter only from the choices given.");
            }
        } while (choose < 1 || choose > 5);
    }


        public void incidentReportMenu(Scanner scan) {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("=== Incident Report Management ===");
            System.out.println("1 - View All Current Incident Reports");
            System.out.println("2 - View Current Incident Reports by Reporter");
            System.out.println("3 - View Current Incident Reports by Id");
            System.out.println("4 - View All Archieve Reports");
            System.out.println("5 - View Archieve Reports by Reporter");
            System.out.println("6 - View Archieve Reports by Id");
            System.out.println("7 - Update Case Status");
            System.out.println("8 - Archieve Reports");
            System.out.println("9 - Exit");
            int choose = scan.nextInt();
            scan.nextLine();
            switch (choose) {
                case 1 -> displayAllCurrentIncidentReports();
                case 2 -> searchIncidentsByReporter(scan, "CurrentIncident");
                case 3 -> System.out.println(searchIncidentById(scan, "CurrentIncident"));
                case 4 -> displayAllArchieveReports();
                case 5 -> searchIncidentsByReporter(scan, "ArchievedIncident");
                case 6 -> System.out.println(searchIncidentById(scan, "ArchievedIncident")); 
                case 7 -> updateCaseStatus(scan);
                case 8 -> arhieveReports(scan);
                case 9 -> isRunning = false;
                default -> System.out.println("Invalid Input, Please enter only from the choices given");
            }
        }
    }
}