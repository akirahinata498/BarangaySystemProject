package BarangayManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class CertificateManager {
    private CertificateRequestStorage certificateRequestStorage;
    private CertificateStatus certificateStatus;

    CertificateManager() {
        this.certificateRequestStorage = CertificateRequestStorage.getInstance();
        this.certificateStatus = new CertificateStatus();
    }

    public void viewAllPendingRequest() {
         if (certificateRequestStorage.getAllRequests().isEmpty()) {
                    System.out.println("No requests found.");
                    return;
                 }
                    for (CertificateRequest certificateRequest : certificateRequestStorage.getAllRequests()) {
                        if (certificateRequest.getStatus().equals("Pending")) {
                            System.out.println(certificateRequest);
                        }
                    }
    }

    public void editStatusRequest(Scanner scan, String statusRequest) {
                scan.nextLine();
                    System.out.print("Enter the Request ID that you want to edit: ");
                    String approveRequest = scan.nextLine();
                    
                for (CertificateRequest certificateRequest : certificateRequestStorage.getAllRequests()) {
                    if (approveRequest.equals(certificateRequest.getId())) {
                        certificateRequest.setStatus(statusRequest);
                        if (certificateRequest.getStatus().equals("Dismissed")) {
                            System.out.print("Enter the reason for rejecting certificate: ");
                            String rejectReason = scan.nextLine();
                            certificateRequest.setReason(rejectReason);
                        }
                        break;
                     }
                }
    }

    

    public void newRequest(Scanner scan, String fname, String mname, String lname) {
        scan.nextLine();
        System.out.println("=== Certificate Request System ===");
        System.out.println("Enter your Purpose");
        String purpose = scan.nextLine();
        String fullName = fname + " " + mname + " " + lname;
        certificateRequestStorage.createRequest(fullName, purpose);
        System.out.println("\nRequest Created Successfully");
    }

    public void residentViewCertificate(String fname, String mname, String lname) {
        String fullName = fname + " " + mname + " " + lname;
        List<CertificateRequest> myRequests = certificateRequestStorage.findRequestsByName(fullName);
        if (myRequests.isEmpty()) System.out.println("No requests found for " + fullName);
        else {
            System.out.println("\n--- YOUR REQUESTS ---");
            for (CertificateRequest r : myRequests) {
                switch (r.getStatus()) {
                    case "Pending" ->  certificateStatus.pendingCertificate(r);
                    case "Approved" -> certificateStatus.approvedCertificate(r);
                    case "Dismissed" -> certificateStatus.dismissedCertificate(r);
                }
            } 
        }
    }

        

    public void adminCertificateManagement(Scanner scan) {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("=== Certificate Management System ===");
            System.out.println("1 - View All Request");
            System.out.println("2 - Approve Request");
            System.out.println("3 - Reject Request");
            System.out.println("4 - Exit");
            int choose = scan.nextInt();
            switch (choose) {
               case 1 -> viewAllPendingRequest();
               case 2 -> editStatusRequest(scan, "Approved");
               case 3 -> editStatusRequest(scan, "Dismissed");
               case 4 -> isRunning = false;
               default -> System.out.println("Invalid Input, Please enter only from the choices given");
            }
        }
    }

}