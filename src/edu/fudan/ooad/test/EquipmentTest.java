package edu.fudan.ooad.test;

import edu.fudan.ooad.entity.Equipment;
import edu.fudan.ooad.entity.Type;
import edu.fudan.ooad.operation.DatabaseOperation;
import edu.fudan.ooad.util.DateUtils;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by lss on 2016/1/4.
 * <p>
 * Test the insertion and deletion of Equipment
 */
public class EquipmentTest extends BaseTest {

    private final static Type type = new Type("type1", "name1");
    private final static Equipment equipment = new Equipment("test1", type.getId(), "model", "location",
            DateUtils.getCurrentTime());

    @Test
    public void testEquipment() {
        type.insert();
        equipment.insert();
        Equipment databaseEquipment = DatabaseOperation.queryById(Equipment.class, equipment.getId());
        assertNotNull("insert failed", databaseEquipment);
        assertEquals("failure in equipment insertion", equipment.toString(), databaseEquipment.toString());
        equipment.delete();
        databaseEquipment = DatabaseOperation.queryById(Equipment.class, equipment.getId());
        assertNull("deletion of equipment failed", databaseEquipment);
    }

}