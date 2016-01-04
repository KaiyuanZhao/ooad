package edu.fudan.ooad.operation;

import edu.fudan.ooad.entity.Equipment;
import edu.fudan.ooad.entity.Plan;
import edu.fudan.ooad.entity.Type;
import edu.fudan.ooad.util.DateUtils;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by Kaiyuan on 2016/1/4.
 */
public class MaintenanceOperation {

    public static List<Plan> getTenDaysPlan(Date date) {
        return Collections.emptyList();
    }

    public static List<Plan> getTenDaysPlan() {
        return getTenDaysPlan(DateUtils.getCurrentTime());
    }

    public static int getTotalMaintenanceTime(Equipment equipment) {
        return 0;
    }

    public static int getTotalMaintenanceTime(Equipment equipment, Type type) {
        return 0;
    }

}
