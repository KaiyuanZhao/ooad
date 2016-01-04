package edu.fudan.ooad.test;

import edu.fudan.ooad.entity.*;
import edu.fudan.ooad.operation.BaseOperation;
import edu.fudan.ooad.operation.MaintenanceOperation;
import edu.fudan.ooad.util.DateUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by lss on 2016/1/4.
 */
public class FunctionTest {
    // test insert equipment
    // test insert maintenance plan for certain type
    // test insert maintenance record for single machine
    // test query maintenance tasks in 10 days
    // test query total maintenance time for certain machine
    // test query total maintenance time for certain machine in certain type
    static Type type1 = new Type("TV", "television");
    static Type type2 = new Type("RR", "refrigerator");
    static Engineer engineer = new Engineer("eng1", "Jack");
    static Equipment equipment1, equipment2, equipment3, equipment4;


    @BeforeClass
    public static void setUp() {
        BaseOperation.insert(type1);
        BaseOperation.insert(type2);
        BaseOperation.insert(engineer);
    }

    @AfterClass
    public static void tearDown() {
        BaseOperation.delete(Record.class);
        BaseOperation.delete(Plan.class);
        BaseOperation.delete(Equipment.class);
        BaseOperation.delete(Type.class);
        BaseOperation.delete(Engineer.class);
    }

    /**
     * test the insertion of equipment
     */
    @Test
    public void testInsertEquipment() {
        equipment1 = new Equipment("A100", type1.getId(), "model", "location",
                DateUtils.getCalendar(2015, 9, 1).getTime());

        equipment2 = new Equipment("A101", type1.getId(), "model", "location",
                DateUtils.getCalendar(2015, 10, 5).getTime());

        equipment3 = new Equipment("A200", type2.getId(), "model", "location",
                DateUtils.getCalendar(2015, 10, 1).getTime());

        equipment4 = new Equipment("A201", type2.getId(), "model", "location",
                DateUtils.getCalendar(2015, 11, 5).getTime());

        BaseOperation.insert(equipment1);
        BaseOperation.insert(equipment2);
        BaseOperation.insert(equipment3);
        BaseOperation.insert(equipment4);
        assertNotNull("failure in equipment insertion", BaseOperation.queryAll(Equipment.class));
        assertEquals("failure in equipment insertion", 4, BaseOperation.queryAll(Equipment.class).size());

    }

    /**
     * test the insertion of plan
     */
    @Test
    public void testInsertPlan() {
        Plan p1 = new Plan("plan0", type1.getId(), 30, "small", "comment");
        Plan p2 = new Plan("plan1", type1.getId(), 60, "large", "comment");
        Plan p3 = new Plan("plan2", type2.getId(), 30, "small", "comment");
        Plan p4 = new Plan("plan3", type2.getId(), 60, "large", "comment");
        BaseOperation.insert(p1);
        BaseOperation.insert(p2);
        BaseOperation.insert(p3);
        BaseOperation.insert(p4);
        assertNotNull("failure in plan insertion", BaseOperation.queryAll(Plan.class));
        assertEquals("failure in plan insertion", 4, BaseOperation.queryAll(Plan.class).size());
    }

    /**
     * test insert record
     */
    @Test
    public void testInsertRecord() {
        Record r0 = new Record("r1", "plan0", "A100", engineer.getId(),
                DateUtils.getCalendar(2015, 10, 1).getTime(), 3, "cleaning");

        Record r1 = new Record("r2", "plan0", "A100", engineer.getId(),
                DateUtils.getCalendar(2015, 11, 1).getTime(), 3, "checking");

        Record r2 = new Record("r3", "plan1", "A100", engineer.getId(),
                DateUtils.getCalendar(2015, 11, 1).getTime(), 5, "testing");

        Record r3 = new Record("r4", "plan0", "A101", engineer.getId(),
                DateUtils.getCalendar(2015, 11, 1).getTime(), 4, "washing");

        Record r4 = new Record("r5", "plan2", "A201", engineer.getId(),
                DateUtils.getCalendar(2016, 0, 5).getTime(), 2, "cleaning");

        Record r5 = new Record("r6", "plan2", "A200", engineer.getId(),
                DateUtils.getCalendar(2015, 11, 1).getTime(), 3, "fixing bugs");

        Record r6 = new Record("r7", "plan3", "A200", engineer.getId(),
                DateUtils.getCalendar(2016, 0, 1).getTime(), 5, "repairing");

        BaseOperation.insert(r0);
        BaseOperation.insert(r1);
        BaseOperation.insert(r2);
        BaseOperation.insert(r3);
        BaseOperation.insert(r4);
        BaseOperation.insert(r5);
        BaseOperation.insert(r6);
        assertEquals("something wrong with record insert", 7, BaseOperation.queryAll(Record.class).size());
    }

    @Test
    public void testGetMonthTask() {
        List<Task> l = MaintenanceOperation.getMonthTask(2015, 11);
        assertEquals("something wrong with get month tasks", 4, l.size());
    }

    @Test
    public void testGetTenDayTask() {
        List<Task> l1 = MaintenanceOperation.getTenDaysTask(DateUtils.getCalendar(2015, 10, 27).getTime());
        assertEquals("something wrong with get 10 days' tasks - 1", 4, l1.size());
        List<Task> l2 = MaintenanceOperation.getTenDaysTask(DateUtils.getCalendar(2016, 1, 1).getTime());
        assertEquals("something wrong with get 10 days tasks - 2", 1, l2.size());
    }

    @Test
    public void testGetTotalMaintenanceTime() {
        int i1 = MaintenanceOperation.getTotalMaintenanceTime("A100");
        assertEquals("wrong with total time of equipment1", i1, 11);
        int i2 = MaintenanceOperation.getTotalMaintenanceTime("A101");
        assertEquals("wrong with total time of equipment2", i2, 4);
        int i3 = MaintenanceOperation.getTotalMaintenanceTime("A200");
        assertEquals("wrong with total time of equipment3", i3, 8);
        int i4 = MaintenanceOperation.getTotalMaintenanceTime("A201");
        assertEquals("wrong with total time of equipment4", i4, 2);

        int i5 = MaintenanceOperation.getTotalMaintenanceTime(equipment1, "plan0");
        assertEquals("wrong with total time in certain type - equipment1", i5, 6);
        int i6 = MaintenanceOperation.getTotalMaintenanceTime(equipment3, "plan2");
        assertEquals("wrong with total time of certain type - equipment3", i6, 3);
    }


}
