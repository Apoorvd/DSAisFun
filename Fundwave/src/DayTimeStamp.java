//import java.time.LocalDate;
//import java.time.Month;
//
//public class DayTimeStamp {
//
//    public static void printDays(int year, Month month, int date) {
//        LocalDate start = LocalDate.of(year, month, date);
//
//        Month endMonth = start.getMonth().plus(3);
//
//        int flag = 0;
//        if(start.isLeapYear())
//            flag = 1;
//        LocalDate end = LocalDate.of(year, endMonth, flag+date);
//
//        int y = start.getYear() % 100;
//        int m = start.getMonthValue();
//
//        String s = yearname[m-1] + y;
//
//        list.add(s);
//
//
//    }
//}
