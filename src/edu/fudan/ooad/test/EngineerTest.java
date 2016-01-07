package edu.fudan.ooad.test;

import edu.fudan.ooad.entity.Engineer;
import edu.fudan.ooad.operation.DatabaseOperation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by lss on 2016/1/4.
 */
public class EngineerTest extends BaseTest {

    @Test
    public void testInsertEngineer() {
        Engineer engineer = new Engineer("eng1", "Jack");
        engineer.insert();
        Engineer databaseEngineer = DatabaseOperation.queryById(Engineer.class, engineer.getId());
        assertNotNull("insert failed for engineer", databaseEngineer);
        assertEquals("Failure in engineer insertion!", engineer, databaseEngineer);
    }
}
