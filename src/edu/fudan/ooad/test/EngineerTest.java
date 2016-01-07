package edu.fudan.ooad.test;

import edu.fudan.ooad.entity.Engineer;
import edu.fudan.ooad.operation.DatabaseOperation;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by lss on 2016/1/4.
 * <p>
 * Test the insertion and deletion of Engineer
 */
public class EngineerTest extends BaseTest {

    private final static Engineer engineer = new Engineer("eng1", "Jack");

    @Test
    public void testInsertEngineer() {
        engineer.insert();
        Engineer databaseEngineer = DatabaseOperation.queryById(Engineer.class, engineer.getId());
        assertNotNull("insert failed for engineer", databaseEngineer);
        assertEquals("Failure in engineer insertion!", engineer, databaseEngineer);
    }

    @Test
    public void testDeleteEngineer() {
        engineer.delete();
        Engineer databaseEngineer = DatabaseOperation.queryById(Engineer.class, engineer.getId());
        assertNull("deletion of engineer failed", databaseEngineer);
    }
}
