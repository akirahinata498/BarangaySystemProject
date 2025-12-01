package BarangayManagementSystem;

import java.util.LinkedList;

public class FinancialRecorderManager {
    private LinkedList<FinancialRecord> barangayRecord = new LinkedList<>();

    private static FinancialRecorderManager single_instance = null;
        public static synchronized FinancialRecorderManager getInstance() {
        if (single_instance == null) {
            single_instance = new FinancialRecorderManager();
        }
        return single_instance;
    }

    public void addRecord(FinancialRecord record) {
        barangayRecord.add(record);
    }

    public LinkedList<FinancialRecord> getAllRecords() {
        return barangayRecord;
    }
}
