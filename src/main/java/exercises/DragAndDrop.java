package exercises;

import driverFactory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class DragAndDrop {

    private static WebDriver driver;


    public static void dragAndDrop1(String driverName) {
        getDriver(driverName);
        String URL = "http://www.dhtmlx.com/docs/products/dhtmlxTree/index.shtml";

        driver.get(URL);


        WebElement From = driver.findElement(By.xpath(".//*[@id='treebox1']/div/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[4]/span"));

        WebElement To = driver.findElement(By.xpath(".//*[@id='treebox2']/div/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[4]/span"));

        Actions builder = new Actions(driver);

        Action dragAndDrop = builder.clickAndHold(From)

                .moveToElement(To)

                .release(To)

                .build();

        dragAndDrop.perform();

        closeDriver();
    }

    private static void getDriver(String driverName) {
        driver = DriverFactory.getDriver(driverName);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
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
