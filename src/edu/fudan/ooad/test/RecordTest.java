package edu.fudan.ooad.test;

import edu.fudan.ooad.entity.Equipment;
import edu.fudan.ooad.entity.Plan;
import edu.fudan.ooad.entity.Record;
import edu.fudan.ooad.entity.Type;
import edu.fudan.ooad.operation.BaseOperation;
import edu.fudan.ooad.util.DateUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


import static junit.framework.TestCase.assertNotNull;

/**
 * Created by lss on 2016/1/4.
 */
public class RecordTest {

    static Type tv = new Type("TV", "television");
    static Equipment equipment = new Equipment("A100", tv.getId(), "TCL", "Shanghai",
            DateUtils.transferTimeStringToDate("2015-01-01", "YYYY-MM-DD"));
    static Plan plan = new Plan("plan1", tv.getId(), 30, "small", "");

    @BeforeClass
    public static void setUp(){
        BaseOperation.insert(tv);
        BaseOperation.insert(equipment);
        BaseOperation.insert(plan);
    }

    @Test
    public void testInsertRecord(){
        Record record1 = new Record("rec1", "plan1", "A100", "eng1",
                DateUtils.transferTimeStringToDate("2015-01-30", "YYYY-MM-DD"), 2, "cleaning");
        BaseOperation.insert(record1);
        assertNotNull("failure in record insertion", BaseOperation.queryAll(Record.class));
        BaseOperation.delete(record1);
    }

    @AfterClass
    public static void tearDown(){
        BaseOperation.delete(tv);
        BaseOperation.delete(equipment);
        BaseOperation.delete(plan);
    }

}
