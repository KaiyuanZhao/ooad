package edu.fudan.ooad.test;

import edu.fudan.ooad.entity.Type;
import edu.fudan.ooad.operation.DatabaseOperation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by lss on 2016/1/4.
 */
public class TypeTest extends BaseTest {

    @Test
    public void testInsertType() {
        Type type = new Type("eng1", "Jack");
        type.insert();
        Type databaseType = DatabaseOperation.queryById(Type.class, type.getId());
        assertNotNull("insert failed for type", databaseType);
        assertEquals("Failure in type insertion!", type, databaseType);
        type.delete();
    }
}
