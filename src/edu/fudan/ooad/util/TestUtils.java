package edu.fudan.ooad.util;

import edu.fudan.ooad.entity.*;
import edu.fudan.ooad.operation.DatabaseOperation;

/**
 * Created by Kaiyuan on 2016/1/7.
 */
public class TestUtils {

    public static void deleteAll() {
        DatabaseOperation.delete(Record.class);
        DatabaseOperation.delete(Plan.class);
        DatabaseOperation.delete(Equipment.class);
        DatabaseOperation.delete(Type.class);
        DatabaseOperation.delete(Engineer.class);
    }

}
