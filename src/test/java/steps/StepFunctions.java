package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.LoginPage;

import java.nio.file.Path;
import java.nio.file.Paths;

public class StepFunctions extends BaseSteps{


    @Before
    public void setup() {
        //Logging
        logger= Logger.getLogger("nopCommerceSDET");
        PropertyConfigurator.configure("Log4j.properties");
        logger.setLevel(Level.DEBUG);

        // Initialize the page objects
        Path pathDriver= Paths.get("src", "drivers","chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", pathDriver.toAbsolutePath().toString());
        driver= new ChromeDriver();
        // Set up any additional configurations if needed
        driver.manage().window().maximize();
    }

    @Given("^Go to Home Page (.+) and click Login$")
    public void goToHomePageAndClickLogin(String url) {
        logger.info("************* Launching Browser *****************");
        driver.get(url);
        // Initialize the LoginPage object******
        lp=new LoginPage(driver);
        lp.clickGetLogin();
    }

    @Given("^Login with (.+) and (.+)$")
    public void loginWithUsernameAndPassword(String userName, String password) {
        logger.info("************* set user name and password *****************");
        lp.setUserName(userName);
        lp.setPassword(password);
    }

    @Given("^Click on Login Button$")
    public void clickOnLoginButton() throws InterruptedException {
        logger.info("************* click login button *****************");
        lp.clickLogin();
        Thread.sleep(5000);
    }

}
