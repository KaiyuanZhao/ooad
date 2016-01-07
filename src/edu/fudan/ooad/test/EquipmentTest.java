package edu.fudan.ooad.test;

import edu.fudan.ooad.entity.Equipment;
import edu.fudan.ooad.entity.Type;
import edu.fudan.ooad.operation.DatabaseOperation;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by lss on 2016/1/4.
 */
public class EquipmentTest extends BaseTest {
    private static Type type = new Type("type1", "name1");

    @BeforeClass
    public static void setUPBeforeTest() {
        type.insert();
    }

    /**
     * test the insertion of equipment
     */
    @Test
    public void testInsertEquipment() {
        // add equipment
        Equipment equipment = new Equipment("test1", type.getId(), "model", "location", Calendar.getInstance().getTime());
        equipment.insert();
        Equipment databaseEquipment = DatabaseOperation.queryById(Equipment.class, equipment.getId());
        assertNotNull("insert failed", databaseEquipment);
        assertEquals("failure in equipment insertion", equipment.toString(), databaseEquipment.toString());
    }

}