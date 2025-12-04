package BarangayManagementSystem;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//after fixing the system make sure to fix the codebase so it wont look like a spahetti code
//the spgahettti code i feel like are newcounterecord, deleterecord and findrecord methods.
public abstract class FinancialRecord implements Transparancy {
    private String financeID;
    private double totalCost;

    private String transactionType;
    private String dateOfTransaction;
    private String unitOfMeasure;

    private String status;
        protected FinancialRecorderManager financeManager;
     protected LocalDate today = LocalDate.now();
      protected int year = today.getYear();
        FinancialRecord(String financeID,  String transactionType, String dateOfTransaction, String status) {
            this.financeID = financeID;
            this.transactionType = transactionType;
            this.dateOfTransaction = dateOfTransaction;
            this.status = status;
        }   


FinancialRecord() {
            this.financeManager = FinancialRecorderManager.getInstance();

}
    //getters
    public String getFinanceID() {
        return financeID;
    }
    public double getTotalCost() {
        return totalCost;
    }
    public String getTransactionType() {
        return transactionType;
    }
    public String getDateOfTransaction() {
        return dateOfTransaction;
    }
    public String getStatus() {
        return status;
    }


    //setters
    public void setFinanceID(String financeID){
        this.financeID = financeID;
    }
    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
    public void setDateOfTransaction(String dateOfTransaction) {
        this.dateOfTransaction = dateOfTransaction;
    }
    public void setStatus(String status) {
        this.status = status;
    }


    public String certificateNumberGeneration(String startID) {

    // Make a copy of the list to avoid changing the original
    List<FinancialRecord> sorted = new LinkedList<>(financeManager.getAllRecords());

    // Sort by numeric part of the ID
    sorted.sort(Comparator.comparingInt(r ->
        Integer.parseInt(r.getFinanceID().split("-")[2])
    ));

    int idNumber = 1;

    for (FinancialRecord req : sorted) {
        int current = Integer.parseInt(req.getFinanceID().split("-")[2]);

        if (current != idNumber) {
            // Found the first missing ID
            break;
        }

        idNumber++; // Move to next number
    }

    return startID + "-" + year + "-" + String.format("%05d", idNumber);
}

    
    
	public String TransactionDate(Scanner scan) {
		boolean isRunning = true;
		String month = "";
		String day = "";
		String year = "";
		while (isRunning) {
			System.out.println("Enter the month of Transaction E.G 1 for january");

			try {
			byte monthchoose = scan.nextByte();
			 month= "";
			switch (monthchoose) {
			case 1 -> month = "January";
			case 2 -> month = "February";
			case 3 -> month = "March";
			case 4 -> month = "April";
			case 5 -> month = "May";
			case 6 -> month = "June";
			case 7 -> month = "July";
			case 8 -> month = "August";
			case 9 -> month = "September";
			case 10 -> month = "October";
			case 11 -> month = "November";
			case 12 -> month = "December";
			default -> {
				System.out.println("Please choose something properly");
				continue;
				}
			}
			System.out.println("Enter the date of Transaction");
			byte dayscan = scan.nextByte();
			 day = "";
			if (dayscan <= 0 || dayscan > 31) {
				System.out.println("Please enter a proper date");
				continue;
			}
			else {
				day = Integer.toString(dayscan);
			}
			System.out.println("Enter year of Transaction");
			int yearscan = scan.nextInt();
			 year = "";
			if (yearscan < 1950 || yearscan > 2025) {
				System.out.println("Please enter a proper year");
				continue;
			}
			else {
				year = Integer.toString(yearscan);
			}
			}catch (Exception e) {
				System.out.println("Please enter a proper answer");
				scan.nextLine();
				continue;
			}
			isRunning = false;
		}
	
	
	return month + "-" + day + "-" +  year;
	}
    public FinancialRecord findRecord(Scanner scan) {
      
            System.out.print("Enter the Payroll ID of user that you want to edit: ");
            String findRecord = scan.nextLine();
            for (FinancialRecord records : financeManager.getAllRecords()) {
                if (records instanceof PayrollRecord && findRecord.equals(records.getFinanceID())) {
                    return records;
                }
                else if (records instanceof ProcurementRecord && findRecord.equals(records.getFinanceID())) {
                    return records;
                }
                else if (records instanceof MaintenanceRecord && findRecord.equals(records.getFinanceID())) {
                    return records;
                }
            }
            return null;
    }   

}
