package exercises;

import contants.Constant;
import driverFactory.DriverFactory;
import exercises.Excel.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class ApachePOI {
    private static WebDriver driver = null;

    public static void main(String[] args) throws Exception {
        ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Sheet1" );
        driver = DriverFactory.getDriver("FIREFOX");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Constant.URL);
        SignIn_Action.Execute(driver);
        System.out.println("Login Successfully, now it is the time to Log Off buddy.");
        String xpathLogout = "//*[@id=\"account_logout\"]/a";

        driver.findElement(By.xpath(xpathLogout)).click();

        driver.quit();
        ExcelUtils.setCellData("Pass", 1, 3);
        System.out.println("Should have saved the file");
    }
}
