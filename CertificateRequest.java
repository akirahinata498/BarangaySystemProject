package BarangayManagementSystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CertificateRequest {
    private String id;
    private String name;
    private String certificateType;
    private String purpose;
    private LocalDateTime dateCreated;
    private String status;
    private String reason;

    public CertificateRequest(String id, String name,  String purpose) {
        this.id = id;
        this.name = name;
        this.certificateType = "Barangay Clearance";
        this.purpose = purpose;
        this.dateCreated = LocalDateTime.now();
        this.status = "Pending";   
    }
//getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getCertificateType() { return certificateType; }
    public String getPurpose() { return purpose; }
    public String getStatus() { return status; }
    public String getReason() { return reason; }
    public String getDateCreated() {
        return dateCreated.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }


    public void setStatus(String status) {
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

   @Override
    public String toString() {
        return  "================ CERTIFICATE REQUEST ================\n" +
            "Request ID: " + id + "\n" +
            "Resident Name: " + name + "\n" +
            "Certificate: " + certificateType + "\n" +
            "Purpose: " + purpose + "\n" +
            "Date Requested: " + dateCreated + "\n" +
            "Status: " + status + "\n";
    }
}