package school.sptech.exerciciojpavalidation.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    public static String dataAtualPlus(int dias, int meses, int anos) {
        return LocalDate.now()
                .plusDays(dias)
                .plusMonths(meses)
                .plusYears(anos)
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
