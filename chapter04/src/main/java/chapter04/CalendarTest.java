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

        calendar.set(Calendar.YEAR, 2024);
        calendar.set(Calendar.MONTH, 11); // 12월(Month - 1)
        calendar.set(Calendar.DATE, 25);
        printDate(calendar);

        calendar.set(2000, 9, 6);
        calendar.add(Calendar.DATE, 300);
        printDate(calendar);
    }

    public static void printDate(Calendar calendar) {
        final String[] DAYS = {"일", "월", "화", "수", "목", "금", "토"};

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH); // 0 ~ 11, +1
        int date = calendar.get(Calendar.DATE);
        int day = calendar.get(Calendar.DAY_OF_WEEK); // 1(일) ~ 7(토)
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        System.out.println(year + "년 " +
                (month + 1) + "월 " +
                date + "일 " +
                DAYS[day - 1] + "요일 " +
                hour + "시 " +
                minute + "분 " +
                second + "초");
    }
}
