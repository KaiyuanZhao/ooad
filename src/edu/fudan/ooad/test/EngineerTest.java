package edu.fudan.ooad.test;

import edu.fudan.ooad.entity.Engineer;
import edu.fudan.ooad.operation.DatabaseOperation;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by lss on 2016/1/4.
 */
public class EngineerTest {
    @Test
    public void testInsertEngineer() {
        Engineer engineer = new Engineer("eng1", "Jack");
        DatabaseOperation.insert(engineer);
        List<Engineer> list = DatabaseOperation.queryById(Engineer.class, engineer.getId());
        assertNotNull("insert failed for engineer", list);
        assertEquals("Failure in engineer insertion!", engineer, list.get(0));
        DatabaseOperation.delete(engineer);
    }
}
