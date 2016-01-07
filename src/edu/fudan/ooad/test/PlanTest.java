package edu.fudan.ooad.test;

import edu.fudan.ooad.entity.Equipment;
import edu.fudan.ooad.entity.Plan;
import edu.fudan.ooad.entity.Type;
import edu.fudan.ooad.operation.DatabaseOperation;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Calendar;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 * Created by lss on 2016/1/4.
 */
public class PlanTest extends BaseTest {
    // test insert maintenance plan for certain type
    // test queryById maintenance tasks in 10 days

    private static Type type = new Type("type1", "name1");
    private static Equipment equipment = new Equipment("id1", type.getId(), "model", "location", Calendar.getInstance().getTime());

    @BeforeClass
    public static void setUpBeforeClass() {
        type.insert();
        equipment.insert();
    }

    @AfterClass
    public static void tearDownAfterClass() {
        DatabaseOperation.delete(type);
        DatabaseOperation.delete(equipment);
    }

    @Test
    public void testInsertPlan() {
        Plan plan = new Plan("p1", type.getId(), 30, "small", "testing");
        plan.insert();
        assertNotNull("failure in plan insertion", DatabaseOperation.queryById(Plan.class, plan.getId()));
        assertEquals("failure in plan insertion", 1, DatabaseOperation.queryAll(Plan.class).size());
        plan.delete();
    }
}
