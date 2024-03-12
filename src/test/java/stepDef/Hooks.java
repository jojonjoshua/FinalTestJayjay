package stepDef;

import helper.Utility;
import io.cucumber.java.*;

import java.util.Objects;

import static helper.Utility.quitDriver;
import static helper.Utility.startDriver;

public class Hooks {

    String tagsRunning = null;

    @BeforeAll
    public static void setUp() {
    }

    @AfterAll
    public static void tearDown() {
    }

    @Before
    public void beforeTest(Scenario scenario) throws InterruptedException {
        String[] tags = scenario.getSourceTagNames().toArray(new String[0]);
        tagsRunning = tags[0];
        if (Objects.equals(tagsRunning, "@web")) {
            startDriver();
        }
    }

    @After
    public void afterTest() throws InterruptedException {
        System.out.println("After Test");

        if (Objects.equals(tagsRunning, "@web")) {
            quitDriver();
        }
    }
}
