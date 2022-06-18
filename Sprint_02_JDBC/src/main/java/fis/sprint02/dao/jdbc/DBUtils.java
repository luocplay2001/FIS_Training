package fis.sprint02.dao.jdbc;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DBUtils {

//    public static void main(String[] args) {
//        System.out.println(convertLocalDateTimeToDate(LocalDateTime.now()));
//    }

    public static LocalDateTime convertDateToLocalDateTime(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return LocalDateTime.parse(simpleDateFormat.format(date).replace(" ","T"));
    }

    public static Timestamp convertLocalDateTimeTimeSQLToLocalDateTimeCode(LocalDateTime localDateTime){
        DateTimeFormatter simpleDateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String s = localDateTime.format(simpleDateFormat);
        return Timestamp.valueOf(s);
    }
}
