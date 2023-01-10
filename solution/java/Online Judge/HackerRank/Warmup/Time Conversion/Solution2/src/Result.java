import java.text.DecimalFormat;

class Result {

    private static final DecimalFormat NUMBER_FORMAT = new DecimalFormat("00");
    public static String timeConversion(String s) {
        String[] clockTimes = s.split(":|AM|PM");
        int hour1_12 = Integer.parseInt(clockTimes[0]);
        int hour0_23 = to24ClockHour(hour1_12, s.endsWith("AM"));
        clockTimes[0] = NUMBER_FORMAT.format(hour0_23);
        return String.join(":",clockTimes);
    }

    private static int to24ClockHour(int hour1_12, boolean isAM) {
        return (hour1_12)%12 + ((isAM)? 0 : 12);
    }

}