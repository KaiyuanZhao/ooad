package edu.fudan.ooad.test;

import edu.fudan.ooad.entity.Equipment;
import edu.fudan.ooad.entity.Record;
import edu.fudan.ooad.entity.Type;
import org.junit.BeforeClass;

import java.util.Calendar;

/**
 * Created by lss on 2016/1/4.
 */
public class RecordTest {
    // test query total maintenance time for certain machine
    // test query total maintenance time for certain machine in certain type

    Type tv = new Type("TV", "television");
    Equipment equipment = new Equipment("A100", tv.getId(), "TCL", "Shanghai", Calendar.getInstance().getTime());

    @BeforeClass
    public static void setUP(){
        Record record1 = new Record("rec1", "plan1", "A100", "eng1", Calendar.getInstance().getTime(), 1, "cleaning");
        Record record2 = new Record("rec2", "plan1", "A100", "eng1", Calendar.getInstance().getTime(), 1, "fixed bugs");
    }

}
