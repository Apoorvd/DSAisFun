import java.io.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class QuarterTimeStamp {

    private static Date start;
    private static Date end;
    private static ArrayList<String> list;
    private static final String[] yearname = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private static final String[] fullyearname = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };

    QuarterTimeStamp()
    {
        this.start = new Date(2013,5,1);
        this.end = new Date(2014,9,2);
    }

    public static void printStartEndQuarter(int year, Month month, int date) {
        LocalDate start = LocalDate.of(year, month, date);

        Month endMonth = start.getMonth().plus(3);

        int flag = 0;
        if(start.isLeapYear())
            flag = 1;
        LocalDate end = LocalDate.of(year, endMonth, flag+date);

        int y = start.getYear() % 100;
        int m = start.getMonthValue();

        String s = yearname[m-1] + y;

        list.add(s);


    }

    public static void main(String args[]) {

        QuarterTimeStamp q = new QuarterTimeStamp();
        list = new ArrayList<>();

        int year = end.year - start.year;
        int month = 0;
        if(end.month >= start.month)
        {
            month = (end.month - start.month) + 12* year;
        }
        else
        {
            month = 12*year - (end.month - start.month);
        }

        System.out.println(month);
        if(end.date > start.date)
            start.month = start.month + month % 3;
        else
            start.month = start.month + month % 3 + 1;

        System.out.println(start.month);
        int x = start.year;
        int i;
        for( i = 0; i < month - month%3 ; i+= 3)
        {
            Month m = Month.valueOf(fullyearname[(start.month + i - 1) % 12].toUpperCase());
            printStartEndQuarter(start.year,m, start.date );
            start.year = (start.month + i)/12 + x;

        }
        Month m = Month.valueOf(fullyearname[(start.month + i - 1) % 12].toUpperCase());
        printStartEndQuarter(start.year, m, start.date);

        System.out.println(list);
        start.year = x;
        getTimePeriods(start, end, "YEAR" );

    }
    static void getTimePeriods(Date fromDate, Date toDate, String timePeriod)
    {
        if(timePeriod.equals("QUARTERS"))
            new QuarterTimeStamp();
//        else if(timePeriod.equals("DAY"))
//            new DayTimeStamp();// create a funtion daytime stamp to do your work
        else
        {
            ArrayList<Integer> yearList = new ArrayList<>();

            for(int i = fromDate.year; i <= toDate.year; i ++)
            {
                yearList.add(i);
            }
            System.out.println(yearList);
        }
    }
}

 class Date{
    int year;
    int month;
    int date;

    Date(int year, int month, int date)
    {
        this.year = year;
        this.month = month;
        this.date = date;
    }

 }
