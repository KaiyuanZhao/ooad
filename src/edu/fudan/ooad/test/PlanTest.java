package edu.fudan.ooad.test;

import edu.fudan.ooad.entity.Equipment;
import edu.fudan.ooad.entity.Plan;
import edu.fudan.ooad.entity.Type;
import edu.fudan.ooad.operation.DatabaseOperation;
import edu.fudan.ooad.util.DateUtils;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by lss on 2016/1/4.
 * <p>
 * Test the insertion and deletion of Plan
 */
public class PlanTest extends BaseTest {

    private final static Type type = new Type("type1", "name1");
    private final static Equipment equipment = new Equipment("id1", type.getId(), "model", "location", DateUtils.getCurrentTime());
    private final static Plan plan = new Plan("p1", type.getId(), 30, "small", "testing");

    @BeforeClass
    public static void setUpBefore() {
        type.insert();
        equipment.insert();
    }

    @Test
    public void testPlan() {
        plan.insert();
        assertNotNull("failure in plan insertion", DatabaseOperation.queryById(Plan.class, plan.getId()));
        assertEquals("failure in plan insertion", 1, DatabaseOperation.queryAll(Plan.class).size());
        plan.delete();
        assertNull("deletion of plan failed", DatabaseOperation.queryById(Plan.class, plan.getId()));
    }
}
