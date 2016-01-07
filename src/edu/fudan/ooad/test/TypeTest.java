package edu.fudan.ooad.test;

import edu.fudan.ooad.entity.Type;
import edu.fudan.ooad.operation.DatabaseOperation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by lss on 2016/1/4.
 */
public class TypeTest extends BaseTest {
    private Type type = new Type("eng1", "Jack");

    @Test
    public void testInsertType() {
        type.insert();
        Type databaseType = DatabaseOperation.queryById(Type.class, type.getId());
        assertNotNull("insert failed for type", databaseType);
        assertEquals("Failure in type insertion!", type, databaseType);
    }

    @Test
    public void testDeleteType(){
        type.delete();
        assertNull("failure in type deletion", DatabaseOperation.queryById(Type.class, type.getId()));
    }
}
