package step_definitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import managers.TestContext;

public class Hooks {

    TestContext testContext;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @Before
    public void BeforeSteps() {

    }

    @After
    public void AfterSteps() {
        testContext.getWebDriverManager().closeDriver();
    }
}