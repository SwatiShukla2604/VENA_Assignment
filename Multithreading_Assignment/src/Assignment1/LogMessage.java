package Assignment1;

import java.text.SimpleDateFormat;
import java.util.Date;

// Class representing a single log message with timestamp and level
public class LogMessage {
    private final String timestamp;
    private final LogLevel level;
    private final String message;

    public LogMessage(LogLevel level, String message) {
        // Capture the current timestamp in readable format
        this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
        this.level = level;
        this.message = message;
    }

    @Override
    public String toString() {
        return "[" + timestamp + "] [" + level + "] " + message;
    }
}
