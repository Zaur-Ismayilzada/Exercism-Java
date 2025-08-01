public class LogLevels {
    
    public static String message(String logLine) {
        int idx    = logLine.indexOf (' ');
		return logLine.substring(idx + 1).trim();
    }

    public static String logLevel(String logLine) {
        int a = logLine.indexOf ('[');
		int b = logLine.lastIndexOf (']');
		return logLine.substring(a + 1, b).toLowerCase ();
    }

    public static String reformat(String logLine) {
       return message (logLine) + " (" + logLevel (logLine) + ")";
    }
}