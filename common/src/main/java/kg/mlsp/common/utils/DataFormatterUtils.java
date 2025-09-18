package kg.mlsp.common.utils;

import java.time.LocalDate;

public class DataFormatterUtils {

    public static LocalDate formatStringToDate(String dateString) {
        return LocalDate.parse(dateString.substring(0, 10));
    }

}
