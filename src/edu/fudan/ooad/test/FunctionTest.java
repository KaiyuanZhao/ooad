package edu.fudan.ooad.test;

import edu.fudan.ooad.entity.Engineer;
import edu.fudan.ooad.entity.Equipment;
import edu.fudan.ooad.entity.Plan;
import edu.fudan.ooad.entity.Type;
import edu.fudan.ooad.operation.BaseOperation;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by lss on 2016/1/4.
 */
public class FunctionTest {
    // test insert equipment
    // test insert maintenance plan for certain type
    // test insert maintenance record for single machine
    // test query maintenance tasks in 10 days
    // test query total maintenance time for certain machine
    // test query total maintenance time for certain machine in certain type
    static Type type = new Type("TV", "television");
    static Engineer engineer = new Engineer("eng1", "Jack");
    Equipment equipment = new Equipment();


    @BeforeClass
    public static void setUp(){
//        Type type = new Type("TV", "television");
        BaseOperation.insert(type);
//        Engineer engineer = new Engineer("eng1", "Jack");
        BaseOperation.insert(engineer);
    }

    /**
     * test the insertion of equipment
     */
    @Test
    public void testInsertEquipment() {
        equipment = new Equipment("A100", "TV", "model", "location", Calendar.getInstance().getTime());
        BaseOperation.insert(equipment);
        List<Equipment> list = BaseOperation.query(Equipment.class, equipment.getId());
        assertEquals("Failure in equipment insertion", equipment, list.get(0));
    }

    /**
     * test the insertion of plan
     */
    @Test
    public void testInsertPlan(){
    }




}
