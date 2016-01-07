package edu.fudan.ooad.test;

import edu.fudan.ooad.entity.Engineer;
import edu.fudan.ooad.operation.BaseOperation;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by lss on 2016/1/4.
 *
 * Test the insertion and deletion of Engineer
 */
public class EngineerTest {
    @Test
    public void testInsertEngineer() {
        Engineer engineer = new Engineer("eng1", "Jack");
        engineer.insert();
        List<Engineer> list = BaseOperation.query(Engineer.class, engineer.getId());
        assertNotNull("insert failed for engineer", list);
        assertEquals("Failure in engineer insertion!", engineer, list.get(0));
        engineer.delete();
    }
}
