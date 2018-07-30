package exercises;

import exercises.Excel.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.Home_Page;


// Now this method does not need any arguments

public class SignIn_Action {

    public static void Execute(WebDriver driver) throws Exception{

        //This is to get the values from Excel sheet, passing parameters (Row num &amp; Col num)to getCellData method

        String sUserName = ExcelUtils.getCellData(1, 1);

        String sPassword = ExcelUtils.getCellData(1, 2);
        System.out.println("Hola desde el singin action, Username: " + sUserName + " sPassword: " + sPassword);

        Home_Page.lnk_MyAccount(driver).click();

        WebElement inputUser = driver.findElement(By.id("log"));
        inputUser.sendKeys(sUserName);

        WebElement passwordInput = driver.findElement(By.id("pwd"));
        passwordInput.sendKeys(sPassword);

        WebElement buttonLogin = driver.findElement(By.id("login"));
        buttonLogin.submit();



        /* Home_Page.lnk_MyAccount(driver).click();

        LogIn_Page.txtbx_UserName(driver).sendKeys(sUserName);

        LogIn_Page.txtbx_Password(driver).sendKeys(sPassword);

        LogIn_Page.btn_LogIn(driver).click();*/

    }

}