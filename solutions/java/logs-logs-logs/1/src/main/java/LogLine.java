public class LogLine {
    private int log_line = -1;
    private String   format; 
    private String[] lines  = {"TRC", "DBG", "INF", "WRN", "ERR", "FTL"};
    
    public LogLine(String logLine) {
        String trimmed = logLine.substring(1, 4);
        for (int i = 0; i < lines.length; i++){
            if (lines[i].equals(trimmed)){
                log_line = i;
                break;
            }
        }

        format = logLine.substring(7);
    }

    public LogLevel getLogLevel() {
        LogLevel[] check = {LogLevel.TRACE, 
                            LogLevel.DEBUG, 
                            LogLevel.INFO, 
                            LogLevel.WARNING, 
                            LogLevel.ERROR, 
                            LogLevel.FATAL, 
                            LogLevel.UNKNOWN};

        if (log_line == -1){
            return check[6];
        }

        return check[log_line];
    }

    public String getOutputForShortLog() {
        return getLogLevel().getN() + ":" + format;
    }
}
