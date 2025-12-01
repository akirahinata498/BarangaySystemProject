package BarangayManagementSystem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class IncidentStorage {
    private List<IncidentReport> incidentList = new ArrayList<>();
    private List<IncidentReport> archieveIncidents = new ArrayList<>();
    private static IncidentStorage single_instance = null;

    // Add new incident
    public void addIncident(IncidentReport incident) {
        incidentList.add(incident);
    }

    // Get all incidents
    public List<IncidentReport> getAllIncidents() {
        return incidentList;
    }


        public static synchronized IncidentStorage getInstance() {
        if (single_instance == null) {
            single_instance = new IncidentStorage();
        }
        return single_instance;
    }
    // Search incident by ID
    public IncidentReport findById(String id) {
        for (IncidentReport incident : incidentList) {
            if (incident.getId().equals(id)) {
                return incident;
            }
        }
        return null;
    }


    public List<IncidentReport> findByReporter(String reporter) {
        List<IncidentReport> result = new ArrayList<>();
        for (IncidentReport incident : incidentList) {
            if (incident.getReporterName().equalsIgnoreCase(reporter)) {
                result.add(incident);
            }
        }
        return result;
    }
    
}
