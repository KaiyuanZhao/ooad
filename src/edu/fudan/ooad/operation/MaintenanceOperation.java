package edu.fudan.ooad.operation;

import edu.fudan.ooad.entity.Equipment;
import edu.fudan.ooad.entity.Plan;
import edu.fudan.ooad.entity.Record;
import edu.fudan.ooad.entity.Task;
import edu.fudan.ooad.provider.HibernateManager;
import edu.fudan.ooad.util.DateUtils;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Kaiyuan on 2016/1/4.
 */
@SuppressWarnings("unchecked")
public class MaintenanceOperation {

    public static final long MILL_SEC_DAY = 60 * 60 * 24 * 1000;

    public static List<Task> getDaysTask(Date date, int days) {
        List<Task> taskList = new ArrayList<>();
        Session session = null;
        try {
            session = HibernateManager.getSession();
            String hqlString = "select equipment, plan from Equipment equipment, Plan plan where equipment.typeId=plan.typeId";
            List<Object[]> equipmentWithPlan = session.createQuery(hqlString).list();
            for (Object[] objects :
                    equipmentWithPlan) {
                Equipment equipment = (Equipment) objects[0];
                Plan plan = (Plan) objects[1];
                Date lastMaintenanceDate = equipment.getTime();
                String newHqlString = String.format("from Record where planId='%s' " +
                                "and equipmentId='%s' order by date desc",
                        plan.getId(), equipment.getId());
                Query query = session.createQuery(newHqlString);
                query.setFirstResult(0);
                query.setMaxResults(1);
                List<Record> records = query.list();
//                System.out.println("=========" + DateUtils.getDateTimeFormatString(date) + "=========");
                if (records != null && records.size() == 1) {
//                    System.out.println(records.get(0));
                    lastMaintenanceDate = records.get(0).getDate();
                }
                Calendar calendar = DateUtils.getCalendar(lastMaintenanceDate);
                calendar.add(Calendar.DAY_OF_YEAR, plan.getSpace());
                Date newDate = calendar.getTime();
                long intervalDays = (newDate.getTime() - date.getTime()) / MILL_SEC_DAY;
//                System.out.println("=========" + intervalDays + "=========" + days + "=============");
                if (intervalDays <= days) {
                    taskList.add(new Task(equipment, plan, newDate));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateManager.closeSession(session);
        }
        return taskList;
    }

    public static List<Task> getTenDaysTask(Date date) {
        return getDaysTask(date, 10);
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
        Calendar calendar = DateUtils.getCalendar(year, month, 1);
        return getDaysTask(calendar.getTime(), calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
    }

    public static int getTotalMaintenanceTime(String equipmentId) {
        String hqlString = String.format("where equipmentId='%s'",
                equipmentId);
        List<Record> records = BaseOperation.queryHQL(Record.class, hqlString);
        int total = 0;
        for (Record record :
                records) {
            total += record.getDuration();
        }
        return total;
    }

    public static int getTotalMaintenanceTime(Equipment equipment, String planId) {
        String hqlString = String.format("where equipmentId='%s' and planId='%s'",
                equipment.getId(), planId);
        List<Record> records = BaseOperation.queryHQL(Record.class, hqlString);
        int total = 0;
        for (Record record :
                records) {
            total += record.getDuration();
        }
        return total;
    }

}
