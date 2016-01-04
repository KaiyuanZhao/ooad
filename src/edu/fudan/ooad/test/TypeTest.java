package edu.fudan.ooad.test;

import edu.fudan.ooad.entity.Type;
import edu.fudan.ooad.operation.BaseOperation;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by lss on 2016/1/4.
 */
public class TypeTest {

    @Test
    public void testInsertType() {
        Type type = new Type("eng1", "Jack");
        BaseOperation.insert(type);
        List<Type> list = BaseOperation.query(Type.class, type.getId());
        assertNotNull("insert failed for type", list);
        assertEquals("Failure in type insertion!", type, list.get(0));
        BaseOperation.delete(type);
    }
}
