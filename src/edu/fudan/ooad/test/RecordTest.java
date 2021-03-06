package edu.fudan.ooad.test;

import edu.fudan.ooad.entity.*;
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
 * Test the insertion and deletion of Record
 */
public class RecordTest extends BaseTest {

    private final static Engineer engineer = new Engineer("eng1", "Jack");
    private final static Type tv = new Type("TV", "television");
    private final static Equipment equipment = new Equipment("A100", tv.getId(), "TCL", "Shanghai",
            DateUtils.getCalendar(2015, 0, 1).getTime());
    private final static Plan plan = new Plan("plan1", tv.getId(), 30, "small", "");
    private final Record record = new Record("rec1", "plan1", "A100", "eng1",
            DateUtils.getCalendar(2015, 0, 30).getTime(), 2, "cleaning");

    @BeforeClass
    public static void setUp() {
        engineer.insert();
        tv.insert();
        equipment.insert();
        plan.insert();
    }

    @Test
    public void testRecord() {
        record.insert();
        assertNotNull("failure in record insertion", DatabaseOperation.queryAll(Record.class));
        assertEquals("something wrong with record insert", 1, DatabaseOperation.queryAll(Record.class).size());
        record.delete();
        assertNull("failure in deletion of record", DatabaseOperation.queryById(Record.class, record.getId()));
    }

}
