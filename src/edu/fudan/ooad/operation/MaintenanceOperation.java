package edu.fudan.ooad.operation;

import edu.fudan.ooad.entity.*;
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
        String hqlString = String.format("where equipmentId='%s' and typeId='%s'",
                equipment.getId(), equipment.getTypeId());
        List<Record> records = BaseOperation.queryHQL(Record.class, hqlString);
        int total = 0;
        for (Record record :
                records) {
            total += record.getDuration();
        }
        return total;
    }

    public static int getTotalMaintenanceTime(Equipment equipment, Plan plan) {
        String hqlString = String.format("where equipmentId='%s' and typeId='%s' and planId='%s'",
                equipment.getId(), equipment.getTypeId(), plan.getId());
        List<Record> records = BaseOperation.queryHQL(Record.class, hqlString);
        int total = 0;
        for (Record record :
                records) {
            total += record.getDuration();
        }
        return total;
    }

}
