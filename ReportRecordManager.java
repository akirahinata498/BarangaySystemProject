package BarangayManagementSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ReportRecordManager {
            private PayrollRecord payrollRecord;
    private MaintenanceRecord maintenanceRecord;
    private ProcurementRecord procurementRecord;
    private FinancialRecorderManager financialRecorderManager;
    private ReportRecordStorage reportRecordStorage;
         private LocalDate today = LocalDate.now();
      private int year = today.getYear();
        ReportRecordManager() {
        this.payrollRecord = new PayrollRecord();
        this.maintenanceRecord = new MaintenanceRecord();
        this.procurementRecord = new ProcurementRecord();
        this.financialRecorderManager = FinancialRecorderManager.getInstance();
        this.reportRecordStorage = ReportRecordStorage.getInstance();
        }


        public void ManageReport(Scanner scan) {
            boolean isRunning = true;
            while (isRunning) {
                System.out.println("Manage Citizen Reports");
                System.out.println("1 - View All Reports");
                System.out.println("2 - Update Status");
                System.out.println("3 - Exit");
                int choose = scan.nextInt();
                scan.nextLine();
                switch (choose) {
                 case 1 -> DisplayReports();
                 case 2 -> UpdateStatus(scan);
                 case 3 -> isRunning = false;
                 default -> System.out.println("Invalid Input, Please enter only from the choices given.");
                }
            }
        }


       public void TransparencyRecordMenu(Scanner scan, String fname, String lname) {
        scan.nextLine();
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Enter choices for Transparency Record");
            System.out.println("1 - View All Payroll Record");
            System.out.println("2 - View All Procurement Record");
            System.out.println("3 - View All Maintenance Record");
            System.out.println("4 - Report a Record");
            System.out.println("5 - Exit");
            int choose = scan.nextInt();
            scan.nextLine();
            switch (choose) {
                case 1 -> payrollRecord.viewAllRecord(scan);
                case 2 -> procurementRecord.viewAllRecord(scan);
                case 3 -> maintenanceRecord.viewAllRecord(scan);
                case 4 -> AddReportFinancialRecord(scan, fname, lname);
                case 5 -> isRunning = false;
                default -> System.out.println("Invalid Input, Please enter proper input only");
            }
        }
    }

    public void AddReportFinancialRecord(Scanner scan, String fname, String lname) {
        System.out.println("Enter the ID of the record that you want to report: ");
        String report = scan.nextLine();
        FinancialRecord reportedRecord = null;
        for (FinancialRecord financialRecord : financialRecorderManager.getAllRecords()) {
            if (report.equals(financialRecord.getFinanceID()) ) {
                reportedRecord = financialRecord;
            }
        }
        if (reportedRecord == null) {
            System.out.println("Invalid Input, Record with that id does not exist.");
            return;
        }
        System.out.print("Enter your concern: ");
        String concern = scan.nextLine();
        String fullName = fname + " " + lname;
        ReportRecord reportRecordData = new ReportRecord(ReportIDGeneration(), concern, reportedRecord, fullName);
        reportRecordStorage.addRecord(reportRecordData);
    }


    private void DisplayReports() {
        for (ReportRecord reports : reportRecordStorage.getAllRecords()) {
            System.out.println(reports);
        }
    }

    private void UpdateStatus(Scanner scan) {
        System.out.print("Enter the Report id that you want to change status: ");
        String reportID = scan.nextLine();
        ReportRecord chosenReport = null;
        for (ReportRecord reports : reportRecordStorage.getAllRecords()) {
            if (reportID.equals(reports.getReportID())) {
                chosenReport = reports;
            }
        }
        if (chosenReport == null) {
            System.out.println("Invalid Input, Please enter a proper input");
            return;
        }
        boolean isRunning = true;
        int chooseStatus = 0;
        String reportStatus = "";
        while (isRunning) {
        System.out.print("Enter the current status for the report: ");
        System.out.println("1 - In Progress");
        System.out.println("2 - Case Solved");
        System.out.println("3 - Police Investigation");
        chooseStatus = scan.nextInt();
        scan.nextLine();
        switch (chooseStatus) {
            case 1 ->  reportStatus = "In Progress";
            case 2 -> reportStatus = "Case Solved";
            case 3 -> reportStatus = "Police Investigation";
            default -> System.out.println("Please enter a proper answer");
            }
            if (chooseStatus >= 1 && chooseStatus <= 3) {
                isRunning = false;
            }
        }
        chosenReport.setStatus(reportStatus);
    }
     public String ReportIDGeneration() {

    // Make a copy of the list to avoid changing the original
    List<ReportRecord> sorted = new ArrayList<>(reportRecordStorage.getAllRecords());

    // Sort by numeric part of the ID
    sorted.sort(Comparator.comparingInt(r ->
        Integer.parseInt(r.getReportID().split("-")[2])
    ));

    int idNumber = 1;

    for (ReportRecord req : sorted) {
        int current = Integer.parseInt(req.getReportID().split("-")[2]);

        if (current != idNumber) {
            // Found the first missing ID
            break;
        }

        idNumber++; // Move to next number
    }

    return "RFR-" + year + "-" + String.format("%05d", idNumber);
}
}
