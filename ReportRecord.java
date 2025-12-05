package BarangayManagementSystem;

public class ReportRecord {
    private String reportID;
    private String reportMessage;
    private FinancialRecord reportedRecord;
    private String status;
    private String fullName;
    ReportRecord(String reportID, String reportMessage, FinancialRecord reportRecord, String fullName) {
        this.reportID = reportID;
        this.reportMessage = reportMessage;
        this.reportedRecord = reportRecord;
        this.fullName = fullName;
        this.status = "Pending";
    }

    //getters
    public String getReportID() {
        return reportID;
    }
    public String getReportMessage(){ 
            return reportMessage;
    }
    public FinancialRecord getReportRecord() {
        return reportedRecord;
    }
    public String getStatus() {
        return status;
    }
    public String getFullName() {
        return fullName;
    }

    //setters 
    public void setReportID(String reportID) {
        this.reportID = reportID;
    }
    public void setReportMessage(String reportMessage) {
        this.reportMessage = reportMessage;
    }
    public void setReportRecord(FinancialRecord reportRecord) {
        this.reportedRecord = reportRecord;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

@Override
public String toString() {
    return "\n=== Financial Record Report ===" +
            "\nReport ID: " + reportID +
           "\nReporter      : " + fullName +
           "\nStatus        : " + status +
           "\nMessage       : " + reportMessage +
           "\nReported Item : " + reportedRecord.toString() +   // calls child toString()
           "\n===============================";
}

}
