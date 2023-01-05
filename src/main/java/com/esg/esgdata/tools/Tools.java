package com.esg.esgdata.tools;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class Tools {

    public static String getTimeFormatted(int hour, int min)
    {
        return String.format(Locale.US, "%02d:%02d%s", hour > 12? hour - 12:hour, min, hour>12?"pm":"am");
    }

    public static int getShiftXShiftsFromX(int startShift, int numShifts)
    {
        int shift = startShift;
        for(int ii = 0; ii < numShifts; ii++)
        {
            if(shift > 14)
                shift -= 14;
        }
        return shift;
    }

    public static double figureNumTraysRoundedUp(double trayValue, double dollarVal)
    {
        double numTrays = 0;
        double interval = trayValue / 2;
        double intervalTotal = 0;
        while(intervalTotal < dollarVal)
        {
            intervalTotal += interval;
            numTrays += 0.5;
        }
        return numTrays;
    }

    public static double figureNumTraysRoundedDown(double trayValue, double dollarVal)
    {
        double numTrays = 0;
        double interval = trayValue / 2;
        double intervalTotal = 0;
        while(intervalTotal + interval < dollarVal)
        {
            intervalTotal += interval;
            numTrays += 0.5;
        }
        return numTrays;
    }

    public static ArrayList<Integer> getShifts(int startShift, int numShifts) {
        ArrayList<Integer> shifts = new ArrayList<>();
        int shift = startShift;
        for(int ii = 0; ii < numShifts; ii++)
        {
            shifts.add(shift);
            shift++;
            if(shift > 14)
                shift -= 14;
        }
        return shifts;
    }

    public static boolean isToday(int dayOfYear) {
        Calendar today = Calendar.getInstance();
        return today.get(Calendar.DAY_OF_YEAR) == dayOfYear;
    }

    public static boolean isToday(LocalDate date) {
        return date.equals(LocalDate.now());
    }

    private static int getWeekFor(LocalDate date, int firstDayOfYear) {
        return (int)((date.getDayOfYear() - firstDayOfYear) / 7);
    }

    private static int getCurrentWeek(int firstDayOfYear) {

        return LocalDate.now().getDayOfYear() < firstDayOfYear? getWeekFor(LocalDate.ofYearDay(LocalDate.now().getYear() - 1, 365), firstDayOfYear) : getWeekFor(LocalDate.now(), firstDayOfYear);
    }


    public static int getShiftFor(LocalDate date, boolean isAM) {
        switch(date.getDayOfWeek())
        {
            case SUNDAY:
                return isAM? 9:10;
            case MONDAY:
                return isAM? 11:12;
            case TUESDAY:
                return isAM? 13:14;
            case WEDNESDAY:
                return isAM? 1:2;
            case THURSDAY:
                return isAM? 3:4;
            case FRIDAY:
                return isAM? 5:6;
            case SATURDAY:
                return isAM? 7:8;
        }
        return 1;
    }

    public static boolean isFutureDay(LocalDate c) {
        LocalDate now = LocalDate.now();
        return c.getYear() > now.getYear() || (c.getYear() == now.getYear() && c.getDayOfYear() > now.getDayOfYear());
    }

    public static String formatCalendar(Calendar c) {
        return String.format("%d|%d|%d", c.get(Calendar.MONTH) + 1, c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.YEAR));
    }

    public static Calendar getCalendarFor(int month, int day, int year) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, day);
        c.set(Calendar.YEAR, year);
        return c;
    }

}
