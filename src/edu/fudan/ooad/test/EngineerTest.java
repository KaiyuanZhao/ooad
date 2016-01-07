package edu.fudan.ooad.test;

import edu.fudan.ooad.entity.Engineer;
import edu.fudan.ooad.operation.DatabaseOperation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by lss on 2016/1/4.
 *
 * Test the insertion and deletion of Engineer
 */
public class EngineerTest extends BaseTest {
    private Engineer engineer = new Engineer("eng1", "Jack"), databaseEngineer;


    @Test
    public void testEngineer() {
        engineer.insert();
        databaseEngineer = DatabaseOperation.queryById(Engineer.class, engineer.getId());
        assertNotNull("insert failed for engineer", databaseEngineer);
        assertEquals("Failure in engineer insertion!", engineer, databaseEngineer);
        engineer.delete();
        databaseEngineer = DatabaseOperation.queryById(Engineer.class, engineer.getId());
        assertNull("deletion of engineer failed", databaseEngineer);
    }
}
