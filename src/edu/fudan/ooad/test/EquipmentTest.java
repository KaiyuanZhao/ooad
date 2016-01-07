package edu.fudan.ooad.test;

import edu.fudan.ooad.entity.Equipment;
import edu.fudan.ooad.entity.Type;
import edu.fudan.ooad.operation.DatabaseOperation;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by lss on 2016/1/4.
 *
 * Test the insertion and deletion of Equipment
 */
public class EquipmentTest extends BaseTest {
    private Type type = new Type("type1", "name1");
    private Equipment equipment = new Equipment("test1", type.getId(), "model", "location", Calendar.getInstance().getTime());
    private Equipment databaseEquipment;

    @Test
    public void testInsertEquipment() {
        type.insert();
        equipment.insert();
        databaseEquipment = DatabaseOperation.queryById(Equipment.class, equipment.getId());
        assertNotNull("insert failed", databaseEquipment);
        assertEquals("failure in equipment insertion", equipment.toString(), databaseEquipment.toString());
    }

    @Test
    public void testDeleteEquipment(){
        equipment.delete();
        databaseEquipment = DatabaseOperation.queryById(Equipment.class, equipment.getId());
        assertNull("deletion of equipment failed", databaseEquipment);
    }

}