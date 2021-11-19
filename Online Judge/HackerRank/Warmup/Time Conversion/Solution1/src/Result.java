import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

class Result {

    private static final DateTimeFormatter CLOCK_FORM_12 = DateTimeFormatter.ofPattern("hh:mm:ssa",new Locale("en"));
    private static final DateTimeFormatter CLOCK_FORM_24 = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static String timeConversion(String s) {
        LocalTime time = LocalTime.parse(s, CLOCK_FORM_12);
        String time24 = CLOCK_FORM_24.format(time);
        return time24;
    }

}