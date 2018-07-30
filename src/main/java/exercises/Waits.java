package exercises;

import com.google.common.base.Function;
import driverFactory.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Waits {
    private static WebDriver driver;
    /**
     * FLUENT WAITS
     *
     */

    /**
     * CHECK ELEMENT  --- FUNCIONA
     */
    public static void fluentWait2(String driverName) {
        driver = DriverFactory.getDriver(driverName);
        driver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");

        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.pollingEvery(Duration.ofMillis(250));
        wait.withTimeout(Duration.ofMinutes(2));
        wait.ignoring(NoSuchElementException.class); //make sure that this exception is ignored
        Function<WebDriver, WebElement> function = arg0 -> {
            System.out.println("Checking for the element!!");
            WebElement element = arg0.findElement(By.id("target"));
            if(element != null)
            {
                System.out.println("Target element found");
            }
            return element;
        };

        wait.until(function);
    }


    /**
     * COLOR - No funciona
     */
    public static void fluentWait1(String driverName) {

        driver = DriverFactory.getDriver(driverName);
        driver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");

        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
        wait.pollingEvery(250,  TimeUnit.MILLISECONDS);
        wait.withTimeout(2, TimeUnit.SECONDS);

        Function<WebDriver, Boolean> function = Waits::apply;

        wait.until(function);
    }

    private static Boolean apply(WebDriver arg0) {
        WebElement element = arg0.findElement(By.id("colorVar"));
        String color = element.getAttribute("style");
        System.out.println("The color if the button is " + color);
        return color.equals("red;");
    }

    /**
     * 1) Launch new Browser
     *
     * 2) Open URL “http://toolsqa.wpengine.com/automation-practice-switch-windows/”
     *
     * 3) Click on the Button “Timing Alert”
     *
     * 4) Accept the Alert (Alert will take 3 second to get displayed, Use WebDriverWait to wait for it)
     */

    public static void waitExercise(String driverName) {
        driver = DriverFactory.getDriver(driverName);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("timingAlert")).click();

        System.out.println("[TIMING ALERT TRIGGER]");

        WebDriverWait wait = new WebDriverWait(driver, 10);

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        alert.accept();
        System.out.println("[ALERT ACCEPTED]");
        closeDriver();
    }

    private static void closeDriver(){
        sleep(5000);
        driver.close();
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
