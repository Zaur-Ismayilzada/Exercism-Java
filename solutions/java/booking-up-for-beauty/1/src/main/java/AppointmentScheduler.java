import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.DayOfWeek;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

class AppointmentScheduler {
    public LocalDateTime schedule(String appointmentDateDescription) {
        int idx = appointmentDateDescription.indexOf(" ");

        String year = appointmentDateDescription.substring(0, idx);
        String time = appointmentDateDescription.substring(idx + 1);

        DateTimeFormatter parser1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter parser2 = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        LocalTime t = LocalTime.parse(time, parser2);
        LocalDate d = LocalDate.parse(year, parser1);
        return LocalDateTime.of(d, t);
    }

    public boolean hasPassed(LocalDateTime appointmentDate) {
        LocalDateTime curr_time = LocalDateTime.now();

        return curr_time.isAfter(appointmentDate);
    }

    public boolean isAfternoonAppointment(LocalDateTime appointmentDate) {
        int hour = appointmentDate.getHour();

        return hour >= 12 && hour < 18;
    }

    public String getDescription(LocalDateTime appointmentDate) {
        String day_of_week = appointmentDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.US);
        String month       = appointmentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.US);
        String day         = appointmentDate.getDayOfMonth() + "";
        String year        = appointmentDate.getYear() + "";

        DateTimeFormatter time_formatter = DateTimeFormatter.ofPattern("h:mm a");
        String            time           = appointmentDate.format(time_formatter);
        

        return "You have an appointment on " + day_of_week + ", " + month + " " + 
               day + ", " + year + ", at " + time + ".";
    }

    public LocalDate getAnniversaryDate() {
        return LocalDate.of(LocalDate.now().getYear(), 9, 15);
    }
}
