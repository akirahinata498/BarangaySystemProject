package BarangayManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class ArchieveStorage {
        private List<IncidentReport> archieveIncidents = new ArrayList<>();
    private static ArchieveStorage single_instance = null;
        public void addArchieve (IncidentReport incidentReport) {
            archieveIncidents.add(incidentReport);
        }

        public List<IncidentReport> getAllArchieveIncidents() {
            return archieveIncidents;
        }

        public static synchronized ArchieveStorage getInstance() {
        if (single_instance == null) {
            single_instance = new ArchieveStorage();
        }
        return single_instance;
    }

    public IncidentReport findById(String id) {
for (IncidentReport incident : archieveIncidents) {
            if (incident.getId().equals(id)) {
                return incident;
            }
        }
        return null;
    }

        public List<IncidentReport> findByReporter(String reporter) {
        List<IncidentReport> result = new ArrayList<>();
        for (IncidentReport incident : archieveIncidents) {
            if (incident.getReporterName().equalsIgnoreCase(reporter)) {
                result.add(incident);
            }
        }
        return result;
    }
}
