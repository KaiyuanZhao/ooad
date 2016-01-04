package edu.fudan.ooad.operation;

import edu.fudan.ooad.entity.Equipment;
import edu.fudan.ooad.entity.Task;
import edu.fudan.ooad.entity.Type;
import edu.fudan.ooad.util.DateUtils;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by Kaiyuan on 2016/1/4.
 */
public class MaintenanceOperation {

    public static List<Task> getTenDaysTask(Date date) {
        return Collections.emptyList();
    }

    public static List<Task> getTenDaysTask() {
        return getTenDaysTask(DateUtils.getCurrentTime());
    }

    public static List<Task> getMonthTask() {
        Calendar calendar = DateUtils.getCalendar();
        return getMonthTask(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH));
    }

    public static List<Task> getMonthTask(int month) {
        return getMonthTask(DateUtils.getCalendar().get(Calendar.YEAR), month);
    }

    public static List<Task> getMonthTask(int year, int month) {
        return Collections.emptyList();
    }

    public static int getTotalMaintenanceTime(Equipment equipment) {
        return 0;
    }

    public static int getTotalMaintenanceTime(Equipment equipment, Type type) {
        return 0;
    }

}
