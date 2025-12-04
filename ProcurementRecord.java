package BarangayManagementSystem;

import java.util.Scanner;

public class ProcurementRecord extends FinancialRecord{
    private String item;
    private String purpose;
    private String supplier;
    private double unitCost;
    private int quantity;

    ProcurementRecord(String financeID, String dateOfTransaction, String status, String item, String purpose, String supplier, double unitCost, int quantity){ 
        super(financeID, "Procurement", dateOfTransaction, status);
        setItem(item);
        setPurpose(purpose);
        setSupplier(supplier);
        computeTotalCost(unitCost, quantity, this);
    }

    ProcurementRecord() {
    }

    @Override
    public void addRecord(Scanner scan) {
        scan.nextLine();
        String financeID = certificateNumberGeneration("PRC");
        System.out.print("Enter Item Name: ");
        String itemName = scan.nextLine();
        System.out.print("Enter Item's Purpose: ");
        String itemPurpose = scan.nextLine();
        System.out.print("Enter Item's Unit Cost: ");
        double itemUnitCost = scan.nextDouble();
        System.out.print("Enter quantity: ");
        int itemQuantity = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter Item's Supplier: ");
        String itemSupplier = scan.nextLine();
        String transactionDate = TransactionDate(scan);
        scan.nextLine();
        System.out.print("Enter Transaction Status: ");
        String status = scan.nextLine();
        ProcurementRecord procurementRecord = new ProcurementRecord(financeID, transactionDate, status, itemName, itemPurpose, itemSupplier, itemUnitCost, itemQuantity);
        financeManager.addRecord(procurementRecord);
    }

    @Override
    public void deleteRecord(Scanner scan) {
        scan.nextLine();
             System.out.print("Enter the Procurement id that you want to delete: ");
        String procurementID = scan.nextLine();
        for (FinancialRecord financeRecord : financeManager.getAllRecords()) {
            if (financeRecord instanceof ProcurementRecord && procurementID.equals(financeRecord.getFinanceID())) {
                financeManager.getAllRecords().remove(financeRecord);
                System.out.println("Record deleted Successfully");
                break;
            }
        }
    }

    @Override
    public void viewAllRecord(Scanner scan) {
       for (FinancialRecord records : financeManager.getAllRecords()) {
        if (records instanceof ProcurementRecord procurementRecord) {
            System.out.println(procurementRecord.toString());
        }
       }
    }
    @Override
    public void editRecord(Scanner scan) {
        scan.nextLine();
        boolean isRunning = true;
                    ProcurementRecord procurementRecord = (ProcurementRecord) findRecord(scan);
            if (procurementRecord == null) {
                System.out.println("Invalid Input, ID does not exist.");
                return;
            }
        while (isRunning) {

            System.out.println("=== Edit Procurement Record ===");
            System.out.println("1 - Transaction Date");
            System.out.println("2 - Status");
            System.out.println("3 - Item Name");
            System.out.println("4 - Item Purpose");
            System.out.println("5 - Item Cost");
            System.out.println("6 - Item Quantity");
            System.out.println("7 - Item Supplier");
            System.out.println("8 - Exit");
            int choose = scan.nextInt();
            scan.nextLine();
            switch (choose) {
                case 1 : 
                    String transactionDate = TransactionDate(scan);
                    procurementRecord.setDateOfTransaction(transactionDate);
                    break;
                case 2 :
                    System.out.print("Edit Status: ");
                    String editStatus = scan.nextLine();
                    procurementRecord.setStatus(editStatus);
                    break;
                case 3 : 
                    System.out.print("Edit Item Name: ");
                    String editItemName = scan.nextLine();
                    procurementRecord.setItem(editItemName);
                    break;
                case 4 :
                    System.out.print("Edit Item Purpose: ");
                    String editPurpose = scan.nextLine();
                    procurementRecord.setPurpose(editPurpose);
                    break;
                case 5 :
                    System.out.print("Edit Item Unit Cost: ");
                    int editUnitCost = scan.nextInt();
                    procurementRecord.computeTotalCost(editUnitCost, procurementRecord.getQuantity(), procurementRecord);
                    break;
                case 6 :
                    System.out.print("Edit Item Quantity: ");
                    int editQuantity = scan.nextInt();
                    procurementRecord.computeTotalCost(procurementRecord.getUnitCost(), editQuantity, procurementRecord);
                    break;
                case 7 :
                    System.out.print("Edit Item Supplier: ");
                    String editSupplier = scan.nextLine();
                    procurementRecord.setSupplier(editSupplier);
                    break;
                case 8 :
                    isRunning = false;
                    break;
                default :
                    System.out.println("Invalid Input, Enter only from the choices given.");
                    break;
            }
        }
    }

    public void computeTotalCost(double unitCost, int quantityCost, ProcurementRecord procurement) {
        procurement.setUnitCost(unitCost);
        procurement.setQuantity(quantityCost);
         setTotalCost(procurement.getUnitCost() * procurement.getQuantity());
    }

    //getteres
    public String getItem() {
        return item;
    }
    public String getPurpose() {
        return purpose;
    }
    public String getSupplier() {
        return supplier;
    }
    public double getUnitCost() {
        return unitCost;
    }
    public int getQuantity() {
        return quantity;
    }



    ///setters
    public void setItem(String item) {
        this.item = item;
    }
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    @Override
    public String toString() {
        return "Procurement ID: " + getFinanceID() + "\n" +
               "Transaction Type: " + getTransactionType() + "\n" + 
               "Item Type: " + getItem() + "\n" +
               "Purpose: " + getPurpose() + "\n" + 
               "Unit Cost: " + getUnitCost() + "\n" + 
               "Quantity: " + getQuantity() + "\n" + 
               "Total Cost: " + getTotalCost() + "\n" +
               "Supplier: " + getSupplier() + "\n" + 
               "Date of Transaction: " + getDateOfTransaction() + "\n" +
               "Transaction Status: " + getStatus() + "\n"; 
    }
}   
