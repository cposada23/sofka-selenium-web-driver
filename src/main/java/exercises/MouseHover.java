package exercises;

import driverFactory.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class MouseHover {

    private static WebDriver driver;
    private static final String testUrl = "http://store.demoqa.com/";



    public static void mouseHover(String driverName) {
        getDriver(driverName);
        driver.get(testUrl);
        driver.manage().window().maximize();

        WebElement element = driver.findElement(By.linkText("Product Category"));
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        WebElement subElement = driver.findElement(By.linkText("iPads"));
        action.moveToElement(subElement);
        action.click();
        action.perform();
        closeDriver();
    }

    private static void getDriver(String driverName) {
        driver = DriverFactory.getDriver(driverName);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private static void closeDriver(){
        sleep(5000);
        driver.close();
        driver.quit();
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
