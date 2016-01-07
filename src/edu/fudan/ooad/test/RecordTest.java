package edu.fudan.ooad.test;

import edu.fudan.ooad.entity.*;
import edu.fudan.ooad.operation.BaseOperation;
import edu.fudan.ooad.util.DateUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 * Created by lss on 2016/1/4.
 *
 * Test the insertion and deletion of Record
 */
public class RecordTest {

    static Engineer engineer = new Engineer("eng1", "Jack");
    static Type tv = new Type("TV", "television");
    static Equipment equipment = new Equipment("A100", tv.getId(), "TCL", "Shanghai",
            DateUtils.getCalendar(2015, 0, 1).getTime());
    static Plan plan = new Plan("plan1", tv.getId(), 30, "small", "");

    @BeforeClass
    public static void setUp() {
        engineer.insert();
        tv.insert();
        equipment.insert();
        plan.insert();
    }

    @AfterClass
    public static void tearDown() {
        plan.insert();
        equipment.insert();
        tv.insert();
    }

    @Test
    public void testInsertRecord() {
        Record record1 = new Record("rec1", "plan1", "A100", "eng1",
                DateUtils.getCalendar(2015, 0, 30).getTime(), 2, "cleaning");
        record1.insert();
        assertNotNull("failure in record insertion", BaseOperation.queryAll(Record.class));
        assertEquals("something wrong with record insert", 1, BaseOperation.queryAll(Record.class).size());
        BaseOperation.delete(record1);
    }

}
