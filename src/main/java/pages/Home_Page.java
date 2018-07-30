package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home_Page {

    public static WebElement lnk_MyAccount(WebDriver driver) throws NoSuchElementException{

        try {
            String xpathMyAcoount = "//*[@id=\"account\"]/a";
            WebElement myAccount = driver.findElement(By.xpath(xpathMyAcoount));
            return myAccount;
        }catch (NoSuchElementException e) {
            throw new NoSuchElementException(e.getMessage());
        }

    }
}
