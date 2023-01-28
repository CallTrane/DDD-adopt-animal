package carl.infr.config;

import java.text.SimpleDateFormat;

/**
 * @className: FormatConfig
 * @description:
 * @author: Carl Tong
 * @date: 2022/4/14 20:59
 */
public class GlobalConfig {

    public static final int PAGE_SIZE = 10;

    public static final SimpleDateFormat getDateFormat() {
        return DateFormat.DATE_FORMAT;
    }

    private static class DateFormat {
        private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
}
