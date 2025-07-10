package testPackage;

import com.shaft.driver.SHAFT;
import com.shaft.gui.internal.locator.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestClass {
    SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON testData;

    String targetUrl = "https://money-collector-fe.azurewebsites.net/";

    private By emailField = By.id("email");
    private By passField = By.id("password");

    @Test
    public void navigateToMonecyCollectorAndAssertLandingPageIsLogin(){
        driver.browser().navigateToURL(targetUrl)
                .and().assertThat().title().contains(testData.getTestData("landingPageTitle"));
    }

    @Test
    public void loginWithValidCredentials(){
        driver.browser().navigateToURL(targetUrl)
                .and().assertThat().title().contains(testData.getTestData("landingPageTitle"));
    }

    @BeforeClass
    public void beforeClass() {
        testData = new SHAFT.TestData.JSON("simpleJSON.json");
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new SHAFT.GUI.WebDriver();
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
}
