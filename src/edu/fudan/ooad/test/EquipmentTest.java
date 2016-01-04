package edu.fudan.ooad.test;

import edu.fudan.ooad.entity.Equipment;
import edu.fudan.ooad.entity.Type;
import edu.fudan.ooad.operation.BaseOperation;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.*;

/**
 * Created by lss on 2016/1/4.
 */
public class EquipmentTest {
    static Type type = new Type("type1", "name1");
    static Equipment equipment = new Equipment("test1", type.getId(), "model", "location", Calendar.getInstance().getTime());

    @BeforeClass
    public static void setUPBeforeTest(){
        BaseOperation.insert(type);
    }

    /**
     * test the insertion of equipment
     */
    @Test
    public void testInsertEquipment() {
        // add equipment
        BaseOperation.insert(equipment);
        List<Equipment> list = BaseOperation.query(Equipment.class, equipment.getId());
        assertNotNull("failure in equipment insertion", list);
        assertEquals(equipment, list.get(0));
    }

    @AfterClass
    public static void tearDownAfterTest(){
        BaseOperation.delete(type);
        BaseOperation.delete(equipment);
    }


}