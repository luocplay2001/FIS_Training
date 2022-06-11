package fis.sprint02.dao.jdbc;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

public class DBUtils {

//    public static void main(String[] args) {
//        System.out.println(convertDateToLocalDateTime(new Date(System.currentTimeMillis())));
//    }

    public static LocalDateTime convertDateToLocalDateTime(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return LocalDateTime.parse(simpleDateFormat.format(date).replace(" ","T"));
    }
}
