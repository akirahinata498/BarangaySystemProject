package BarangayManagementSystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class IncidentReport {
    private String id;
    private String title;
    private String description;
    private String reporterName;
    private LocalDateTime time;
    private String status; 


    public IncidentReport(String id, String title, String description, String reporter, String status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.reporterName = reporter;
        this.time = LocalDateTime.now();
        this.status = status;
    }

    public IncidentReport() {
        //TODO Auto-generated constructor stub
    }


    //getters
    public String getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String getReporterName() {
        return reporterName;
    }
    
    public LocalDateTime getTime() {
        return time;
    }
    public String getStatus(){ 
        return status;
    }


    public void setId(String id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setReporterName(String reporterName) {
        this.reporterName = reporterName;
    }
    public void setTime(LocalDateTime time) {
        this.time = time;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm a");
        return "=== Incident Report ===\n" +
               "ID: " + id + "\n" +
               "Title: " + title + "\n" +
               "Description: " + description + "\n" +
               "Reporter: " + reporterName + "\n" +
               "Reported At: " + time.format(formatter) + "\n" +
               "Description: " + description + "\n" + 
               "Status: " + status + "\n";
    }
}