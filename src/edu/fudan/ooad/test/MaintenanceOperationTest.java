package edu.fudan.ooad.test;

import edu.fudan.ooad.entity.*;
import edu.fudan.ooad.operation.DatabaseOperation;
import edu.fudan.ooad.operation.MaintenanceOperation;
import edu.fudan.ooad.util.DateUtils;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by lss on 2016/1/4.
 * <p>
 * test query maintenance tasks in 10 days
 * test query total maintenance time for certain machine
 * test query total maintenance time for certain machine in certain type
 */
public class MaintenanceOperationTest extends BaseTest {

    private static Type type1 = new Type("TV", "television");
    private static Type type2 = new Type("RR", "refrigerator");
    private static Engineer engineer = new Engineer("eng1", "Jack");
    private static Equipment equipment1, equipment2, equipment3, equipment4;

    @BeforeClass
    public static void setUp() {
        type1.insert();
        type2.insert();
        engineer.insert();
        insertEquipment();
        insertPlan();
        insertRecord();
    }

    /**
     * test the insertion of equipment
     */
    private static void insertEquipment() {
        // A100 - 2015/10/11
        // A101 - 2015/11/5
        // A200 - 2015/11/1
        // A201 - 2015/12/5
        equipment1 = new Equipment("A100", type1.getId(), "model", "location",
                DateUtils.getCalendar(2015, 9, 11).getTime());

        equipment2 = new Equipment("A101", type1.getId(), "model", "location",
                DateUtils.getCalendar(2015, 10, 5).getTime());

        equipment3 = new Equipment("A200", type2.getId(), "model", "location",
                DateUtils.getCalendar(2015, 10, 1).getTime());

        equipment4 = new Equipment("A201", type2.getId(), "model", "location",
                DateUtils.getCalendar(2015, 11, 5).getTime());
        equipment1.insert();
        equipment2.insert();
        equipment3.insert();
        equipment4.insert();
        assertNotNull("failure in equipment insertion", DatabaseOperation.queryAll(Equipment.class));
        assertEquals("failure in equipment insertion", 4, DatabaseOperation.queryAll(Equipment.class).size());
    }

    /**
     * test the insertion of plan
     */
    private static void insertPlan() {
        Plan p1 = new Plan("plan0", type1.getId(), 30, "small", "comment");
        Plan p2 = new Plan("plan1", type1.getId(), 60, "large", "comment");
        Plan p3 = new Plan("plan2", type2.getId(), 30, "small", "comment");
        Plan p4 = new Plan("plan3", type2.getId(), 60, "large", "comment");
        p1.insert();
        p2.insert();
        p3.insert();
        p4.insert();
        assertNotNull("failure in plan insertion", DatabaseOperation.queryAll(Plan.class));
        assertEquals("failure in plan insertion", 4, DatabaseOperation.queryAll(Plan.class).size());
    }

    /**
     * test insert record
     */
//    @Test
    private static void insertRecord() {
        // machine A100 of small maintenance - 2015/11/10
        // machine A100 of small maintenance - 2015/12/10
        // machine A100 of large maintenance - 2015/12/10
        // machine A101 of small maintenance - 2015/12/1
        // machine A200 of small maintenance - 2015/12/1
        // machine A200 of large maintenance - 2016/1/1
        // machine A201 of small maintenance - 2016/1/5
        Record r0 = new Record("r1", "plan0", "A100", engineer.getId(),
                DateUtils.getCalendar(2015, 10, 10).getTime(), 3, "cleaning");

        Record r1 = new Record("r2", "plan0", "A100", engineer.getId(),
                DateUtils.getCalendar(2015, 11, 10).getTime(), 3, "checking");

        Record r2 = new Record("r3", "plan1", "A100", engineer.getId(),
                DateUtils.getCalendar(2015, 11, 10).getTime(), 5, "testing");

        Record r3 = new Record("r4", "plan0", "A101", engineer.getId(),
                DateUtils.getCalendar(2015, 11, 1).getTime(), 4, "washing");

        Record r4 = new Record("r5", "plan2", "A201", engineer.getId(),
                DateUtils.getCalendar(2016, 0, 5).getTime(), 2, "cleaning");

        Record r5 = new Record("r6", "plan2", "A200", engineer.getId(),
                DateUtils.getCalendar(2015, 11, 1).getTime(), 3, "fixing bugs");

        Record r6 = new Record("r7", "plan3", "A200", engineer.getId(),
                DateUtils.getCalendar(2016, 0, 1).getTime(), 5, "repairing");

        r0.insert();
        r1.insert();
        r2.insert();
        r3.insert();
        r4.insert();
        r5.insert();
        r6.insert();
        assertEquals("something wrong with record insert", 7, DatabaseOperation.queryAll(Record.class).size());
    }


    @Test
    public void testGetMonthTask() {
        List<Task> tasks = MaintenanceOperation.getMonthTask(2016, 1);
        assertEquals("something wrong with get month tasks", 8, tasks.size());
    }

    @Test
    public void testGetTenDayTask() {
        List<Task> tasks = MaintenanceOperation.getTenDaysTask(DateUtils.getCalendar(2016, 1, 1).getTime());
        assertEquals("something wrong with get 10 days' tasks - 1", 7, tasks.size());
    }

    @Test
    public void testGetTotalMaintenanceTime() {
        int time1 = MaintenanceOperation.getTotalMaintenanceTime("A100");
        assertEquals("wrong with total time of equipment1", time1, 11);
        int time2 = MaintenanceOperation.getTotalMaintenanceTime("A101");
        assertEquals("wrong with total time of equipment2", time2, 4);
        int time3 = MaintenanceOperation.getTotalMaintenanceTime("A200");
        assertEquals("wrong with total time of equipment3", time3, 8);
        int time4 = MaintenanceOperation.getTotalMaintenanceTime("A201");
        assertEquals("wrong with total time of equipment4", time4, 2);
    }

    @Test
    public void testGetTotalMaintenaceTimeWithPlan() {
        int time1 = MaintenanceOperation.getTotalMaintenanceTime(equipment1, "plan0");
        assertEquals("wrong with total time in certain type - equipment1", time1, 6);
        int time2 = MaintenanceOperation.getTotalMaintenanceTime(equipment3, "plan2");
        assertEquals("wrong with total time of certain type - equipment3", time2, 3);
    }

}
