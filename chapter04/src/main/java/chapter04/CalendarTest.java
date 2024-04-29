package chapter04;

import java.util.Calendar;
//import java.util.Locale;
//import java.util.TimeZone;

public class CalendarTest {
    public static void main(String[] args) {
        // new Calendar(); 캘린더는 new 안됨 -> abstract로 만들어놨기 때문이다.
        Calendar calendar = Calendar.getInstance();

        Calendar.getInstance(); // Factory Method
        // Locale aLocale = Locale.getDefault(Locale.Category.FORMAT);
        // TimeZone tz = TimeZone.getDefault();
        // System.out.println(aLocale + ":" + tz);
        // ko_KR:sun.util.calendar.ZoneInfo[id="Asia/Seoul",offset=32400000,dstSavings=0,useDaylight=false,transitions=30,lastRule=null]

        // now
        printDate(calendar);
    }

    public static void printDate(Calendar calendar) {
        System.out.println(calendar.get(Calendar.YEAR) + " " +
                (calendar.get(Calendar.MONTH) + 1) + " " + // 0
                calendar.get(Calendar.DATE) + " " +
                (calendar.get(Calendar.AM_PM) == 0 ? " " : " ") +
                calendar.get(Calendar.HOUR) + " " +
                calendar.get(Calendar.MINUTE) + " " +
                calendar.get(Calendar.SECOND) + " ");
    }
}
