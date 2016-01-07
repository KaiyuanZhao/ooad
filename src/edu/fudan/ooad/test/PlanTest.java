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
public class PlanTest {
    // test insert maintenance plan for certain type
    // test query maintenance tasks in 10 days

    static Type type = new Type("type1", "name1");
    static Equipment equipment = new Equipment("id1", type.getId(), "model", "location", Calendar.getInstance().getTime());

    @BeforeClass
    public static void setUp() {
        DatabaseOperation.insert(type);
        DatabaseOperation.insert(equipment);
    }

    @AfterClass
    public static void tearDown() {
        DatabaseOperation.delete(type);
        DatabaseOperation.delete(equipment);
    }

    @Test
    public void testInsertPlan() {
        Plan p = new Plan("p1", type.getId(), 30, "small", "testing");
        DatabaseOperation.insert(p);
        assertNotNull("failure in plan insertion", DatabaseOperation.query(Plan.class, p.getId()));
        assertEquals("failure in plan insertion", 1, DatabaseOperation.queryAll(Plan.class).size());
        DatabaseOperation.delete(p);
    }
}
