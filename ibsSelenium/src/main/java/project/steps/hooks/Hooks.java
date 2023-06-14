package project.steps.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import project.managers.InitManager;

public class Hooks {
    @Before
    public void before() {
        InitManager.initFramework();
    }

    @After
    public void after() {
        InitManager.quitFramework();
    }
}
