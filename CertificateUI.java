// package BarangayManagementSystem;

// import java.util.List;
// import java.util.Scanner;

// public class CertificateUI {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         CertificateManager manager = new CertificateManager();

//         boolean running = true;
//         while (running) {
//             System.out.println("\n=== CERTIFICATE REQUEST SYSTEM ===");
//             System.out.println("1. Create New Request");
//             System.out.println("2. View All Requests");
//             System.out.println("3. Search Request by ID");
//             System.out.println("4. View My Requests");
//             System.out.println("5. Exit");
//             System.out.print("Choose an option: ");

//             int choice = -1;
//             try {
//                 choice = scanner.nextInt();
//                 scanner.nextLine();
//             } catch (Exception e) {
//                 System.out.println("Invalid input. Please enter a number.");
//                 scanner.nextLine();
//                 continue;
//             }

//             switch (choice) {
//                 case 1:
//                     System.out.print("Enter Name: ");
//                     String name = scanner.nextLine();
//                     System.out.print("Enter Certificate Type: ");
//                     String type = scanner.nextLine();
//                     System.out.print("Enter Purpose: ");
//                     String purpose = scanner.nextLine();

//                     CertificateRequest request = manager.createRequest(name, type, purpose);
//                     System.out.println("\nRequest Created Successfully!");
//                     System.out.println(request);
//                     break;

//                 case 2:
//                     List<CertificateRequest> allRequests = manager.getAllRequests();
//                     if (allRequests.isEmpty()) System.out.println("No requests found.");
//                     else {
//                         System.out.println("\n--- ALL REQUESTS ---");
//                         for (CertificateRequest r : allRequests) System.out.println(r);
//                     }
//                     break;

//                 case 3:
//                     System.out.print("Enter Request ID to search: ");
//                     try {
//                         int id = scanner.nextInt();
//                         scanner.nextLine();
//                         CertificateRequest found = manager.findRequestById(id);
//                         if (found != null) System.out.println("\nRequest Found:\n" + found);
//                         else System.out.println("Request with ID " + id + " not found.");
//                     } catch (Exception e) {
//                         System.out.println("Invalid ID. Please enter a number.");
//                         scanner.nextLine();
//                     }
//                     break;

//                 case 4:
//                     System.out.print("Enter your Name: ");
//                     String userName = scanner.nextLine();
//                     List<CertificateRequest> myRequests = manager.findRequestsByName(userName);
//                     if (myRequests.isEmpty()) System.out.println("No requests found for " + userName);
//                     else {
//                         System.out.println("\n--- YOUR REQUESTS ---");
//                         for (CertificateRequest r : myRequests) System.out.println(r);
//                     }
//                     break;

//                 case 5:
//                     running = false;
//                     System.out.println("Exiting system...");
//                     break;

//                 default:
//                     System.out.println("Invalid option. Try again.");
//             }
//         }

//         scanner.close();
//     }
// }