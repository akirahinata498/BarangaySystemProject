package BarangayManagementSystem;

import java.time.LocalDateTime;

public class LogEntry {
        private String type;         // "LOGIN" or "ACTIVITY"
    private String message;
    private LocalDateTime timestamp;

    public LogEntry(String type, String message) {
        this.type = type;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public String toString() {
        return "[" + timestamp + "] (" + type + ") " + message;
    }
}
