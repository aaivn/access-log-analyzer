package alexander.ivanov.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {
    private static final String DATE_PATTERN = "dd/MM/yyyy:HH:mm:ss";
    private static final SimpleDateFormat formatter = new SimpleDateFormat(DATE_PATTERN);

    public static Date toDate(String content) {
        Date date = null;
        try {
            date = formatter.parse(content);
        } catch (ParseException e) {
            ErrorHandler.printStackTrace(e.getStackTrace());
        }
        return date;
    }

    public static String toString(Date date) {
        return formatter.format(date);
    }
}