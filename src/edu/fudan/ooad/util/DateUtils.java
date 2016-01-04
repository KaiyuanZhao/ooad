package edu.fudan.ooad.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Date工具类
 * Provide some functions relative to time
 * <p>
 *
 * @author Kaiyuan
 *         2015/8/19
 */
public class DateUtils {

    public static TimeZone getTimeZone() {
        return TimeZone.getTimeZone("GMT+8");
    }

    public static Date getCurrentTime() {
        return getCalendar().getTime();
    }

    public static Calendar getCalendar() {
        return GregorianCalendar.getInstance(getTimeZone(), Locale.CHINA);
    }

    public static Calendar getCalendar(Date date) {
        Calendar calendar = GregorianCalendar.getInstance(getTimeZone(), Locale.CHINA);
        calendar.setTime(date);
        return calendar;
    }

    public static Calendar getCalendar(int year, int month, int dayOfMonth) {
        return getCalendar(null, year, month, dayOfMonth, 0, 0, 0);
    }

    public static Calendar getCalendar(int year, int month, int dayOfMonth, int hourOfDay, int minute, int second) {
        return getCalendar(null, year, month, dayOfMonth, hourOfDay, minute, second);
    }

    public static Calendar getCalendar(Date date, int year, int month, int dayOfMonth, int hourOfDay, int minute, int second) {
        Calendar calendar = getCalendar();
        if (date != null)
            calendar.setTime(date);
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar;
    }

    public static long getCurrentTimeStamp() {
        return getCurrentTime().getTime();
    }

    public static String getDefaultTimeString() {
        return getDateFormat(SimpleDateFormat.getDateTimeInstance()).format(getCurrentTime());
    }

    public static String getCurrentDateString() {
        return getCurrentDateString("yyyy-MM-dd");
    }

    public static String getCurrentDateString(String format) {
        return getDateFormat(format).format(getCurrentTime());
    }

    public static String getStringCurrentTimeOnly() {
        return getStringCurrentTimeOnly("HH:mm");
    }

    public static String getStringCurrentTimeOnly(String format) {
        return getDateFormat(format).format(getCurrentTime());
    }

    public static Date getDateCurrentTimeOnly() {
        return getDateCurrentTimeOnly("HH:mm");
    }

    public static Date getDateCurrentTimeOnly(String format) {
        try {
            return getDateFormat(format).parse(getStringCurrentTimeOnly(format));
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date transferTimeStringToDate(String timeString) {
        return transferTimeStringToDate(timeString, "HH:mm");
    }

    public static Date transferTimeStringToDate(String timeString, String format) {
        try {
            return getDateFormat(format).parse(timeString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getDateFormatString(Date date) {
        return getFormatDateString(date, "yyyy-MM-dd");
    }

    public static String getDateTimeFormatString(Date date) {
        return getFormatDateString(date, "yyyy-MM-dd HH:mm");
    }

    public static String getFormatDateString(Date date, String format) {
        if (date == null)
            return "";
        return getDateFormat(format).format(date);
    }

    public static DateFormat getDateFormat(String format) {
        return getDateFormat(new SimpleDateFormat(format, Locale.CHINA));
    }

    public static DateFormat getDateFormat(DateFormat simpleDateFormat) {
        simpleDateFormat.setTimeZone(getTimeZone());
        return simpleDateFormat;
    }
}
