import driverFactory.DriverFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class SeleniumTests {
    private static WebDriver driver;
    WebElement element;

    @BeforeClass
    public static void openBrowser(){
        driver = DriverFactory.getDriver("CHROME");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void validUserCredentials(){
        System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
        driver.get("http://www.store.demoqa.com");
        String userName = "testuser_3";
        String password = "Test@123";
        
    }

}
