package BarangayManagementSystem;

import java.util.Scanner;


public class PayrollRecord extends FinancialRecord{
    private String employeeName;
    private String emeployeeID;
    private String position;
    private double grossPay;
    private int workingDays;
    private double philHealth;
    private double sss;
    private double pagIbig;
    private double dailyRate;



    

    @SuppressWarnings("OverridableMethodCallInConstructor")
    PayrollRecord(String financeID, String dateOfTransaction, String status, String employeeName, String employeeID
        ,String position,  int workingDays, double dailyRate) {
        super(financeID, "Payroll", dateOfTransaction, status);
        setEmployeeName(employeeName);
        setEmployeeID(employeeID);
        setPosition(position);
        setWorkingDays(workingDays);
        setDailyRate(dailyRate);
        computeGrossPay(getDailyRate(), getWorkingDays(), this);
        computeNetPay(getGrossPay(), getSSS(), getPhilHealth(), getPagIbig(), this);
    }

    PayrollRecord() {

    }


    @Override
    public void addRecord(Scanner scan) {
        scan.nextLine();
       String financeID = certificateNumberGeneration("PAY");
       System.out.print("Enter Employee Name: ");
       String name = scan.nextLine();
       System.out.print("Enter Employee ID: ");
       String id = scan.nextLine();
       System.out.print("Enter Employee Position: ");
       String position = scan.nextLine();
       System.out.print("Enter Number of Working Days: ");
       int workDays = scan.nextInt();
       System.out.print("Daily Rate: ");
       double rate = scan.nextDouble();
       String dateOfTransaction = TransactionDate(scan);
       scan.nextLine();
       System.out.print("Enter the payroll status of user: ");
       String statusUser = scan.nextLine();
       PayrollRecord payroll = new PayrollRecord(financeID, dateOfTransaction, statusUser, name, id, position, workDays, rate);
       financeManager.addRecord(payroll);
    }
    @Override
    public void deleteRecord(Scanner scan) {
            scan.nextLine();
        System.out.print("Enter the Payroll id that you want to delete: ");
        String deleteID = scan.nextLine();
        for (FinancialRecord financeRecord : financeManager.getAllRecords()) {
            if (financeRecord instanceof PayrollRecord && deleteID.equals(financeRecord.getFinanceID())) {
                financeManager.getAllRecords().remove(financeRecord);
                System.out.println("Payroll Record Deleted Successfully");
                break;
            }
        }
    }
    @Override
    public void viewAllRecord(Scanner scan) {
       for (FinancialRecord records : financeManager.getAllRecords()) {
        if (records instanceof PayrollRecord payrollRecord) {
            System.out.println(payrollRecord.toString());
        }
       }
    }
    @Override
    public void editRecord(Scanner scan)  {
          scan.nextLine();
        boolean isRunning = true;
        while (isRunning) {
            PayrollRecord payrollRecord = (PayrollRecord) findRecord(scan);
            if (payrollRecord == null) {
                System.out.println("Invalid Input, ID does not exist");
                break;
            }
          System.out.println("=== Edit Payroll Record ===");
          System.out.println("1 - Transaction Date");
          System.out.println("2 - Status");
          System.out.println("3 - Employee Name");
          System.out.println("4 - Employee Position");
          System.out.println("5 - Enter Working days");
          System.out.println("6 - Daily Rate");
          System.out.println("7 - Exit");
          int choose = scan.nextInt();
          scan.nextLine();
            switch (choose) {
              case 1 : 
              String editTransactionDate = TransactionDate(scan);
              payrollRecord.setDateOfTransaction(editTransactionDate);
              break;
              case 2 :
              System.out.print("Edit Status: ");
              String editStatus = scan.nextLine();
              payrollRecord.setStatus(editStatus);
              break;
              case 3 :
                System.out.print("Edit Employee Name: ");
                String employeeName = scan.nextLine();
                payrollRecord.setEmployeeName(employeeName);
                break;
              case 4 : 
                System.out.print("Edit Employee Position: ");
                String editPosition = scan.nextLine();
                payrollRecord.setPosition(editPosition);
                break;
              case 5 :
                System.out.print("Edit Edit Working days: ");
                int editWorkingDays = scan.nextInt();
                payrollRecord.setWorkingDays(editWorkingDays);
                payrollRecord.computeGrossPay(payrollRecord.getDailyRate(), payrollRecord.getWorkingDays(), payrollRecord);
                payrollRecord.computeNetPay(payrollRecord.getGrossPay(), payrollRecord.getSSS(), payrollRecord.getPhilHealth(), payrollRecord.getPhilHealth(), payrollRecord);
                break;
              case 6 :
                System.out.print("Edit Daily Rate: ");
                double editDailyRate = scan.nextInt();
                payrollRecord.setDailyRate(editDailyRate);
                payrollRecord.computeGrossPay(payrollRecord.getDailyRate(), payrollRecord.getWorkingDays(), payrollRecord);
                payrollRecord.computeNetPay(payrollRecord.getGrossPay(), payrollRecord.getSSS(), payrollRecord.getPhilHealth(), payrollRecord.getPagIbig(), payrollRecord);
                break;
              case 7 :
                isRunning = false;
                break;
              default :
                System.out.println("Invalid Input, Enter only from the choices given");
                break;
            }
        }
    }
    public void computeNetPay(double grossPay, double sss, double philHealth, double pagIbig, PayrollRecord payroll) {
        payroll.setPhilHealth(getGrossPay());
        payroll.setSSS(getGrossPay());
        payroll.setPagIbig(getGrossPay());
        double deductions = payroll.getSSS() + payroll.getPhilHealth() + payroll.getPagIbig();
 
        payroll.setTotalCost(grossPay - deductions);

    }


    public void computeGrossPay(double dailyRate, int workingDays, PayrollRecord payroll) {
        payroll.setGrossPay(dailyRate * workingDays);
    }
    



    

//getters 
public String getEmployeeName() {
    return employeeName;
}
public String getEmployeeID() {
    return emeployeeID;
}
public int getWorkingDays() {
    return workingDays;
}
public String getPosition() {
    return  position;
}
public double getGrossPay() {
    return grossPay;
}
public double getPhilHealth() {
    return philHealth;
}
public double getSSS() {
    return sss;
}
public double getPagIbig() {
    return pagIbig;
}
public double getDailyRate() {
    return dailyRate;
}



//setters
public void setEmployeeName(String employeeName) {
    this.employeeName = employeeName;
}
public void setEmployeeID(String employeeID) {
    this.emeployeeID = employeeID;
}
public void setWorkingDays(int workingDays) {
    this.workingDays = workingDays;
}
public void setPosition(String position) {
    this.position = position;
}
public void setGrossPay(double grossPay) {
    this.grossPay = grossPay;
}


public void setPhilHealth(double philHealth) {
    this.philHealth = (philHealth == 0) ? 0 : philHealth * (3d/100d);
}
public void setSSS(double sss) {
    this.sss = (sss == 0)  ? 0 : (sss * (5d / 100d));
}
public void setPagIbig(double pagIbig) {
    this.pagIbig = (pagIbig == 0) ? 0 : pagIbig * (2d/100d);
}
public void setDailyRate(double dailyRate) {
    this.dailyRate = dailyRate;
}


@Override
public String toString() {
    return 
           "Payroll ID: " + getFinanceID() + "\n" +
           "Transaction Type: " + getTransactionType() + "\n" + 
           "Employee ID: " + getEmployeeID() + "\n" +
           "Employee Name: " + getEmployeeName() + "\n" + 
           "Employee Position: " + getPosition() + "\n" + 
           "Employee Daily Rate: " + getDailyRate() + "\n" +
           "Employee Working Days: " + getWorkingDays() + "\n" +
           "Employee Gross Pay: " + getGrossPay() + "\n" +
           "Employee PhilHealth Contribution: " + getPhilHealth() + "\n" + 
           "Employee SSS Contribution: " + getSSS() + "\n" + 
           "Employee Pag-Ibig Contribution: " + getPagIbig() + "\n" + 
           "Employee Net Pay: " + getTotalCost() + "\n"; 
}


}
