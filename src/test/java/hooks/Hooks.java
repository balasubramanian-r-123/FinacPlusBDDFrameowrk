package hooks;

import webBase.FinacPlusWebBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hooks extends FinacPlusWebBase {
    private static final Logger log = LogManager.getLogger(Hooks.class.getName());

    @Before
    public void setUp(Scenario scenario) {
        log.info("**********Scenario Started::{}**********", scenario.getName());
        initializeBrowser();
        maximizeBrowser();
        implicitWait();
    }

    @After
    public void tearDown(Scenario scenario) {
        log.info("**********Scenario Ended::{}**********", scenario.getName());
        quitBrowser();
    }
}