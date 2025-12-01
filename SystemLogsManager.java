package BarangayManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class SystemLogsManager {
        private List<LogEntry> logs = new ArrayList<>();

    public SystemLogsManager() {
        // Sample logs (in real system these are saved/loaded)
        logs.add(new LogEntry("LOGIN", "Admin John logged in."));
        logs.add(new LogEntry("ACTIVITY", "Approved a certificate request."));
        logs.add(new LogEntry("LOGIN", "Staff Maria logged in."));
    }

    public void addLog(String type, String message) {
        logs.add(new LogEntry(type, message));
    }

    public void viewLoginHistory() {
        System.out.println("\n=== LOGIN HISTORY ===");
        for (LogEntry log : logs) {
            if (log.toString().contains("(LOGIN)"))
                System.out.println(log);
        }
    }

    public void viewActivityLogs() {
        System.out.println("\n=== ACTIVITY LOGS ===");
        for (LogEntry log : logs) {
            if (log.toString().contains("(ACTIVITY)"))
                System.out.println(log);
        }
    }
}
