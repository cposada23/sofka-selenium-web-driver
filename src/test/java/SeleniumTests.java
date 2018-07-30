import driverFactory.DriverFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
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
        String userName = "testuser";
        String password = "Test@123";
        WebElement myAccount = driver.findElement(By.xpath(".//*[@id='account']/a"));
        myAccount.click();

        WebElement user = driver.findElement(By.id("log"));
        user.sendKeys(userName);

        WebElement pwd = driver.findElement(By.id("pwd"));
        pwd.sendKeys(password);

        WebElement logginButton = driver.findElement(By.id("login"));
        logginButton.click();

        try{
            element = driver.findElement(By.xpath(".//*[@id='account_logout']/a"));
        }catch (Exception e) {

        }
        Assert.assertNotNull(element);
        System.out.println("Finishing test " + new Object(){}.getClass().getEnclosingMethod().getName());
    }


    @AfterClass
    public static void closeBrowser(){
        driver.quit();
    }
}
