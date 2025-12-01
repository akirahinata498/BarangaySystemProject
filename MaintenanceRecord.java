package BarangayManagementSystem;

import java.util.Scanner;

public class MaintenanceRecord extends FinancialRecord{

    private String maintenance;
    private String description;
    private String serviceProvider;
    private double laborCost;
    private double materialsCost;
  
    MaintenanceRecord(String financeID,  String dateOfTransaction, String status, String maintenance, String description, String serviceProvider, double laborCost, double materialsCost) {
        super(financeID, "Maintenance", dateOfTransaction, status);
        setMaintenance(maintenance);
        setDescription(description);
        setServiceProvider(serviceProvider);
        computeTotalCost(materialsCost, laborCost, this);
    }

    MaintenanceRecord() {
    }
    
    @Override
    public void addRecord(Scanner scan) {
        scan.nextLine();
        String financeID = "MTR-" +  year + "-" + String.format("%05d", newCountedRecord());
        System.out.print("Enter Maintenance Type: ");
        String maintenanceType = scan.nextLine();
        System.out.print("Enter Maintenance Description: ");
        String maintenanceDescription = scan.nextLine();
        System.out.print("Enter Service Provider: ");
        String serviceProvider = scan.nextLine();
        System.out.print("Enter Labor Cost: ");
        double labor = scan.nextDouble();
        System.out.println("Enter the Materials Cost");
        double materials = scan.nextDouble();
        String transactionDate = TransactionDate(scan);
        scan.nextLine();
        System.out.print("Enter the Transaction Status: ");
        String status = scan.nextLine();
        MaintenanceRecord maintenanceRecord = new MaintenanceRecord(financeID, transactionDate, status, maintenanceType, maintenanceDescription, serviceProvider, labor, materials);
        financeManager.addRecord(maintenanceRecord);
    }



    @Override
    public void deleteRecord(Scanner scan) {
        scan.nextLine();
             System.out.print("Enter the Procurement id that you want to delete: ");
        String procurementID = scan.nextLine();
        for (FinancialRecord financeRecord : financeManager.getAllRecords()) {
            if (financeRecord instanceof MaintenanceRecord && procurementID.equals(financeRecord.getFinanceID())) {
                financeManager.getAllRecords().remove(financeRecord);
                System.out.println("Record deleted Successfully");
                break;
            }
        }
    }

    @Override
    public void viewAllRecord(Scanner scan) {
       for (FinancialRecord records : financeManager.getAllRecords()) {
        if (records instanceof MaintenanceRecord payrollRecord) {
            System.out.println(payrollRecord.toString());
        }
       }
    }

    @Override
    public void editRecord(Scanner scan) {
        scan.nextLine();
        boolean isRunning = true;
        while (isRunning) {
            MaintenanceRecord maintenanceRecord = (MaintenanceRecord) findRecord(scan);
            if (maintenanceRecord == null) {
                System.out.println("Invalid Input, ID does not Exist");
                break;
            }
            System.out.println("=== Edit Maintenance Record ===");
            System.out.println("1 - Transaction Date");
            System.out.println("2 - Status");
            System.out.println("3 - Maintenance Type");
            System.out.println("4 - Maintenance Description");
            System.out.println("5 - Service Provider");
            System.out.println("6 - Materials Cost");
            System.out.println("7 - Labor Cost");
            System.out.println("8 - Exit");
            int choose = scan.nextInt();
            scan.nextLine();
            switch (choose) {
                case 1 : 
                    String editTransactionDate = TransactionDate(scan);
                    maintenanceRecord.setDateOfTransaction(editTransactionDate);
                    break;
                case 2 : 
                    System.out.print("Edit Status: ");
                    String editStatus = scan.nextLine();
                    maintenanceRecord.setStatus(editStatus);
                    break;
                case 3 :
                    System.out.print("Edit Maintenance Type: ");
                    String editMaintenanceType = scan.nextLine();
                    maintenanceRecord.setMaintenance(editMaintenanceType);
                    break;
                case 4 :
                    System.out.print("Edit Maintenance Description:  ");
                    String editMaintenanceDescription = scan.nextLine();
                    maintenanceRecord.setDescription(editMaintenanceDescription);
                    break;
                case 5 :
                    System.out.print("Edit Service Provider: ");
                    String editServiceProvider = scan.nextLine();
                    maintenanceRecord.setServiceProvider(editServiceProvider);
                    break;
                case 6 :
                    System.out.print("Edit Materials Cost: ");
                    double editMaterialsCost = scan.nextDouble();
                    maintenanceRecord.computeTotalCost(editMaterialsCost, maintenanceRecord.getLaborCost(), maintenanceRecord);
                    break;
                case 7 :
                    System.out.print("Edit Labor Cost: ");
                    double editLaborCost = scan.nextDouble();
                    maintenanceRecord.computeTotalCost(maintenanceRecord.getMaterialsCost(), editLaborCost, maintenanceRecord);
                    break;
                case 8 :
                    isRunning = false;
                    break;
                default :
                    System.out.println("Invalid Input, Please enter only from the choices given.");
                    break;
            }

        }
    }

       public void computeTotalCost(double materialsCost, double laborCost, MaintenanceRecord maintenance) {
        maintenance.setMaterialsCost(materialsCost);
        maintenance.setLaborCost(laborCost);
        maintenance.setTotalCost(maintenance.getMaterialsCost() + maintenance.getLaborCost());
    }


    //getters
    private String getMaintenance() {
        return maintenance;
    }
    public String getDescription() {
        return description;
    }
    public String getServiceProvider() {
        return serviceProvider;
    }
    public double getLaborCost() {
        return laborCost;
    }
    public double getMaterialsCost() {
        return materialsCost;
    }


    //setters
    public void setMaintenance(String maintenance) {
        this.maintenance = maintenance;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }
    public void setLaborCost(double laborCost) {
        this.laborCost = laborCost;
    }
    public void setMaterialsCost(double materialsCost) {
        this.materialsCost = materialsCost;
    }


    @Override
    public String toString() {
        return "Maintenance ID: " + getFinanceID() + "\n" + 
               "Transaction Type: " + getTransactionType() + "\n" +
               "Maintenance Type: " + getMaintenance() + "\n" +
               "Maintenance Description: " + getDescription() + "\n" + 
               "Labor Cost: " + getLaborCost() + "\n" + 
               "Materials Cost: " + getMaterialsCost() + "\n" +
               "Total Cost: " + getTotalCost() + "\n" + 
               "Service Provider: " + getServiceProvider() + "\n" + 
               "Date of Transaction: " + getDateOfTransaction()+ "\n" + 
               "Transaction Status: " + getStatus() + "\n" ;
    }
}
