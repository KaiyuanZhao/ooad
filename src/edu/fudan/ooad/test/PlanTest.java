package edu.fudan.ooad.test;

import edu.fudan.ooad.entity.Equipment;
import edu.fudan.ooad.entity.Plan;
import edu.fudan.ooad.entity.Type;
import edu.fudan.ooad.operation.BaseOperation;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Calendar;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 * Created by lss on 2016/1/4.
 *
 * Test the insertion and deletion of Plan
 */
public class PlanTest {

    static Type type = new Type("type1", "name1");
    static Equipment equipment = new Equipment("id1", type.getId(), "model", "location", Calendar.getInstance().getTime());

    @BeforeClass
    public static void setUp() {
        type.insert();
        equipment.insert();
    }

    @AfterClass
    public static void tearDown() {
        type.delete();
        equipment.delete();
    }

    @Test
    public void testInsertPlan() {
        Plan p = new Plan("p1", type.getId(), 30, "small", "testing");
        p.insert();
        assertNotNull("failure in plan insertion", BaseOperation.query(Plan.class, p.getId()));
        assertEquals("failure in plan insertion", 1, BaseOperation.queryAll(Plan.class).size());
        BaseOperation.delete(p);
    }
}
