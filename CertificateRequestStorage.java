package BarangayManagementSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CertificateRequestStorage {
    private List<CertificateRequest> requests = new ArrayList<>();
    private static CertificateRequestStorage single_instance = null;
    
    private int nextId;
     private LocalDate today = LocalDate.now();
      private int year = today.getYear();
    public CertificateRequestStorage() {
        nextId = 1;
    }

   
    public CertificateRequest createRequest(String name,  String purpose) {
        String requestID = "CRI-" + year + "-" + String.format("%05d", (requests.size() + 1));
        CertificateRequest request = new CertificateRequest(requestID, name, purpose);
        requests.add(request);
        return request;
    }

    
    public List<CertificateRequest> getAllRequests() {
        return requests;
    }

    public CertificateRequest findRequestById(String id) {
        for (CertificateRequest request : requests) {
            if (request.getId().equals(id)) return request;
        }
        return null; 
    }

    public List<CertificateRequest> findRequestsByName(String name) {
        List<CertificateRequest> result = new ArrayList<>();
        for (CertificateRequest request : requests) {
            if (request.getName().equalsIgnoreCase(name)) result.add(request);
        }
        return result;
    }

    public static synchronized CertificateRequestStorage getInstance() {
        if (single_instance == null) {
            single_instance = new CertificateRequestStorage();
        }
        return single_instance;
    }
}