package exercises;

import driverFactory.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Alerts {
    private static WebDriver driver;
    private static final String testUrl = "http://toolsqa.wpengine.com/handling-alerts-using-selenium-webdriver/";



    private static void simpleAlert(String driverName) {
        getDriver(driverName);
        driver.get(testUrl);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id='content']/p[4]/button")).click();

        Alert simpleAlert = driver.switchTo().alert();
        String alertText = simpleAlert.getText();
        System.out.println("Alert text is " + alertText);
        simpleAlert.accept();
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
