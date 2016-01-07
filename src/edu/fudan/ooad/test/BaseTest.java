package edu.fudan.ooad.test;

import edu.fudan.ooad.util.TestUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * Created by Kaiyuan on 2016/1/7.
 */
public class BaseTest {

    @BeforeClass
    public static void setUpBeforeTest() {
        TestUtils.deleteAll();
    }

    @AfterClass
    public static void tearDownAfterClass() {
        TestUtils.deleteAll();
    }

}
