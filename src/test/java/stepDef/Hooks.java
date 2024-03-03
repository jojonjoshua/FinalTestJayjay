package stepDef;

import helper.Utility;
import io.cucumber.java.*;

import static helper.Utility.quitDriver;
import static helper.Utility.startDriver;

public class Hooks {

    @BeforeAll
    public static void setUp() {
    }

    @AfterAll
    public static void tearDown() {
    }

    @Before
    public void beforeTest() throws InterruptedException {
        startDriver();
    }

    @After
    public void afterTest() throws InterruptedException {
        Thread.sleep(3000);
        quitDriver();
    }
}
