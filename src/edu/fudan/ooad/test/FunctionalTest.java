package edu.fudan.ooad.test;

import edu.fudan.ooad.entity.*;
import edu.fudan.ooad.operation.BaseOperation;
import edu.fudan.ooad.util.DateUtils;
import org.junit.BeforeClass;

import java.util.Date;

/**
 * Created by lss on 2016/1/6.
 */
public class FunctionalTest {

    private String model = "model", location = "location";

    private Type type = new Type("typeid", "typename");
    private Engineer engineer = new Engineer("eng1", "Jack");
    private Equipment eqpmt1, eqpmt2, eqpmt3, eqpmt4;
    private Plan plan1, plan2;
    private Record record1, record2, record3, record4;

    private Date installTime1 = DateUtils.getCalendar(2015, 11, 1).getTime(),
    installTime2 = DateUtils.getCalendar(2015, 11, 5).getTime(),
    installTime3 = DateUtils.getCalendar(2015, 11, 10).getTime(),
    installTime4 = DateUtils.getCalendar(2015, 11, 15).getTime();

    @BeforeClass
    public void setUp(){
        BaseOperation.insert(type);
        BaseOperation.insert(engineer);

        BaseOperation.insert(eqpmt1 = new Equipment("eq1", type.getId(), model, location, installTime1));
        BaseOperation.insert(eqpmt2 = new Equipment("eq2", type.getId(), model, location, installTime2));
        BaseOperation.insert(eqpmt3 = new Equipment("eq3", type.getId(), model, location, installTime3));
        BaseOperation.insert(eqpmt4 = new Equipment("eq4", type.getId(), model, location, installTime4));

        BaseOperation.insert(plan1 = new Plan("plan1", type.getId(), 30, "small", "checking"));
        BaseOperation.insert(plan2 = new Plan("plan2", type.getId(), 60, "large", "repairing"));

//        BaseOperation.insert(record1 = new Record("record1", plan1.getId(), eqpmt1.getId(), engineer.getId(), ));
    }


}
