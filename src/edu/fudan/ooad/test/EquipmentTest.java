package edu.fudan.ooad.test;

import edu.fudan.ooad.entity.Equipment;
import edu.fudan.ooad.entity.Type;
import edu.fudan.ooad.operation.BaseOperation;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by lss on 2016/1/4.
 *
 * Test the insertion and deletion of Equipment
 */
public class EquipmentTest {
    private static Type type = new Type("type1", "name1");
    private static Equipment equipment = new Equipment("test1", type.getId(), "model", "location", Calendar.getInstance().getTime());

    @BeforeClass
    public static void setUpBeforeTest() {
        type.insert();
    }

    @AfterClass
    public static void tearDownAfterTest() {
        equipment.delete();
        type.delete();
    }

    /**
     * test the insertion of equipment
     */
    @Test
    public void testInsertEquipment() {
        equipment.insert();
        List<Equipment> list = BaseOperation.query(Equipment.class, equipment.getId());
        assertEquals("failure in equipment insertion", list.size(), 1);
    }


}