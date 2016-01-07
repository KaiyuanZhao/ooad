package edu.fudan.ooad.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by lss on 2016/1/5.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({EngineerTest.class, TypeTest.class, EquipmentTest.class, PlanTest.class,
        RecordTest.class, MaintenanceOperationTest.class, MainFlowTest.class})
public class TestAll {
}
