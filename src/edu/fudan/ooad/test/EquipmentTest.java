package edu.fudan.ooad.test;

import edu.fudan.ooad.entity.Equipment;
import edu.fudan.ooad.entity.Type;
import edu.fudan.ooad.operation.DatabaseOperation;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by lss on 2016/1/4.
 */
public class EquipmentTest {
    static Type type = new Type("type1", "name1");
    static Equipment equipment = new Equipment("test1", type.getId(), "model", "location", Calendar.getInstance().getTime());

    @BeforeClass
    public static void setUPBeforeTest() {
        DatabaseOperation.insert(type);
    }

    @AfterClass
    public static void tearDownAfterTest() {
        DatabaseOperation.delete(equipment);
        DatabaseOperation.delete(type);
    }

    /**
     * test the insertion of equipment
     */
    @Test
    public void testInsertEquipment() {
        // add equipment
        DatabaseOperation.insert(equipment);
        List<Equipment> list = DatabaseOperation.query(Equipment.class, equipment.getId());
        assertEquals("failure in equipment insertion", list.size(), 1);
    }


}