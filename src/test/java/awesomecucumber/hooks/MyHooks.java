package awesomecucumber.hooks;

import awesomecucumber.context.TestContext;
import awesomecucumber.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class MyHooks {

    private TestContext context;
    private WebDriver driver;

    public MyHooks(TestContext context){
        this.context= context;
    }


    @Before
    public void before(Scenario scenario){
        context.scenarioName =  scenario.getName();
        driver = DriverFactory.initializeDriver(System.getProperty("browser", "chrome"));
    }

    @After
    public void after(){
        driver.quit();
    }
}
