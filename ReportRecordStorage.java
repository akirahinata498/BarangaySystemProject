package BarangayManagementSystem;

import java.util.LinkedList;

public class ReportRecordStorage {
    private LinkedList<ReportRecord> reportRecord = new LinkedList<>();
        private static ReportRecordStorage single_instance = null;
        public static synchronized ReportRecordStorage getInstance() {
        if (single_instance == null) {
            single_instance = new ReportRecordStorage();
        }
        return single_instance;
    }
    public void addRecord(ReportRecord record) {
        reportRecord.add(record);
    }

    public LinkedList<ReportRecord> getAllRecords() {
        return reportRecord;
    }
}
