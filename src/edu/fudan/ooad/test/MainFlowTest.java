package edu.fudan.ooad.test;

import edu.fudan.ooad.entity.*;
import edu.fudan.ooad.operation.MaintenanceOperation;
import edu.fudan.ooad.util.DateUtils;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by lss on 2016/1/6.
 */
public class MainFlowTest {

    private String model = "model", location = "location";

    private Type type = new Type("typeid", "typename");
    private Engineer engineer = new Engineer("eng1", "Jack");
    private Equipment eqpmt1, eqpmt2;
    private Plan plan1, plan2;
    private Record record1, record2, record3, record4;

    private Date installTime1 = DateUtils.getCalendar(2015, 10, 1).getTime(),
    installTime2 = DateUtils.getCalendar(2015, 10, 5).getTime();

    @Test
    public void mainFlowTest(){
        // insert data
        // install two machine in 2015/11/1 and 2015/11/5
        // two type of plans with interval 30 and 60
        // 2 records of machine 1 in 2015/12/1 and 2015/12/31
        // 2 records of machine 2 in 2015/12/5 and 2016/1/4
        type.insert();
        engineer.insert();
        eqpmt1 = new Equipment("eqpmt1", type.getId(), model, location, installTime1);
        eqpmt2 = new Equipment("eqpmt2", type.getId(), model, location, installTime2);
        eqpmt1.insert();
        eqpmt2.insert();
        plan1 = new Plan("plan1", type.getId(), 30, "large", "checking");
        plan2 = new Plan("plan2", type.getId(), 60, "small", "repairing");
        plan1.insert();
        plan2.insert();
        record1 = new Record("r1", plan1.getId(), eqpmt1.getId(), engineer.getId(),
                DateUtils.getCalendar(2015, 11, 1).getTime(), 2, "换过滤网");
        record2 = new Record("r2", plan2.getId(), eqpmt1.getId(), engineer.getId(),
                DateUtils.getCalendar(2015, 11, 31).getTime(), 1, "发动机清理");
        record3 = new Record("r3", plan1.getId(), eqpmt2.getId(), engineer.getId(),
                DateUtils.getCalendar(2015, 11, 5).getTime(), 3, "cleaning");
        record4 = new Record("r4", plan2.getId(), eqpmt2.getId(), engineer.getId(),
                DateUtils.getCalendar(2016, 0, 4).getTime(), 2, "tiny repairing");
        record1.insert();
        record2.insert();
        record3.insert();
        record4.insert();

        // test the correctness of 10 days tasks
        List<Task> tenDayTasks = MaintenanceOperation.getTenDaysTask(DateUtils.getCalendar(2015, 11, 30).getTime());
        assertEquals("wrong with 10 days' tasks", 2, tenDayTasks.size());

        // test the total maintenance time
        int time1 = MaintenanceOperation.getTotalMaintenanceTime(eqpmt1.getId());
        assertEquals("wrong with total time of equipment 1", 3, time1);
        int time2 = MaintenanceOperation.getTotalMaintenanceTime(eqpmt2.getId());
        assertEquals("wrong with total time of equipment 2", 5, time2);

        // test the total maintenance time of certain type
        int time3 = MaintenanceOperation.getTotalMaintenanceTime(eqpmt1, plan1.getId());
        assertEquals("wrong with total time of equipment 1 of plan 1", 2, time3);
        int time4 = MaintenanceOperation.getTotalMaintenanceTime(eqpmt1, plan2.getId());
        assertEquals("wrong with total time of equipment 1 of plan 1", 1, time4);
        int time5 = MaintenanceOperation.getTotalMaintenanceTime(eqpmt2, plan1.getId());
        assertEquals("wrong with total time of equipment 1 of plan 1", 3, time5);
        int time6 = MaintenanceOperation.getTotalMaintenanceTime(eqpmt2, plan2.getId());
        assertEquals("wrong with total time of equipment 1 of plan 1", 2, time6);
    }


}
