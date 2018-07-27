import driverFactory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Exercices {
    private static WebDriver driver;

    /**
     * TABLES
     * Launch new Browser
     * Open URL “http://toolsqa.wpengine.com/automation-practice-table/”
     * Get the value from cell ‘Dubai’ and print it on the console
     * Click on the link ‘Detail’ of the first row and last column
     */
    public static void tablesExercise1(String driverName) {
        getDriver(driverName);
        driver.get("http://toolsqa.wpengine.com/automation-practice-table/");
        /** Get the value from cell ‘Dubai’ and print it on the console */
        WebElement cell = driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[1]/td[2]"));
        System.out.println("Value" + cell.getText());
        /** Click on the link ‘Detail’ of the first row and last column */
        //*[@id="content"]/table/tbody/tr[1]/td[6]/a
        By xpath = By.xpath("//*[@id=\"content\"]/table/tbody/tr[1]/td[6]/a");
        WebElement linkDetail = driver.findElement(xpath);
        linkDetail.click();
        sleep(5000);
        closeDriver();
    }

    /**
     * TABLES
     * Launch new Browser
     * Open URL “http://toolsqa.wpengine.com/automation-practice-table/”
     * Get the value from cell ‘Dubai’ with using dynamic xpath
     * Print all the column values of row ‘Clock Tower Hotel’
     */

    public static void tablesExercise2(String driverName) {
        getDriver(driverName);
        driver.get("http://toolsqa.wpengine.com/automation-practice-table/");
        /** Get the value from cell ‘Dubai’ with using dynamic xpath */
        String row = "1";
        String col = "2";
        WebElement cell = driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[" + row + "]/td[" + col + "]"));
        System.out.println("Value" + cell.getText());
        /** Print all the column values of row ‘Clock Tower Hotel’ */

        //*[@id="content"]/table/tbody/tr[1]/th
        String rowName = "Clock Tower Hotel";
        for (int i = 1; i < 5; i++) {
            String value = null;
            value = driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[" + i + "]/th")).getText();
            if (value.equalsIgnoreCase(rowName)) {
                //*[@id="content"]/table/tbody/tr[2]/td[1]
                for (int j = 1; j <= 5; j++) {
                    String columnValue = driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[" +  i + "]/td[ "  + j +"]")).getText();
                    System.out.println("ColumnValue: " + columnValue);
                }

            }
        }
        closeDriver();
    }


    /**
     * DROP DOWN AND SELECT
     * Launch new Browser
     *     Open “http://toolsqa.wpengine.com/automation-practice-form/”
     *     Select ‘Continents’ Drop down ( Use Id to identify the element )
     *     Select option ‘Europe’ (Use selectByIndex)
     *     Select option ‘Africa’ now (Use selectByVisibleText)
     *     Print all the options for the selected drop down and select one option of your choice
     *     Close the browser
     */
    public static void dropDownSelectExercice1(String driverName) {
        driver = DriverFactory.getDriver(driverName);
        String url = "http://toolsqa.wpengine.com/automation-practice-form/";
        driver.get(url);
        /** Select ‘Continents’ Drop down ( Use Id to identify the element  */
        Select continentDropDown = new Select(driver.findElement(By.id("continents")));
        /** Select option ‘Europe’ (Use selectByIndex)*/
        continentDropDown.selectByIndex(1);
        /** Select option ‘Africa’ now (Use selectByVisibleText) */
        continentDropDown.selectByVisibleText("Africa");
        /** Print all the options for the selected drop down and select one option of your choice */
        List<WebElement> options = continentDropDown.getOptions();
        int size = options.size();

        String value;
        for (int i = 0; i < size; i++) {
            value = options.get(i).getText();
            System.out.println(value);
        }

        closeDriver();

    }
    /**
     *
     * DROP DOWN AND SELECT
     * Launch new Browser
     * Open “http://toolsqa.wpengine.com/automation-practice-form/”
     * Select ‘Selenium Commands’ Multiple selection box ( Use Name locator to identify the element )
     * Select option ‘Browser Commands’  and then deselect it (Use selectByIndex and deselectByIndex)
     * Select option ‘Navigation Commands’  and then deselect it (Use selectByVisibleText and deselectByVisibleText)
     * Print and select all the options for the selected Multiple selection list.
     * Deselect all options
     * Close the browser
     */

    public static void dropDownSelectExercice2(String driverName) {
        getDriver(driverName);
        String url = "http://toolsqa.wpengine.com/automation-practice-form/";
        driver.get(url);
        /** Select ‘Selenium Commands’ Multiple selection box ( Use Name locator to identify the element )  */
        Select multipleSelectBox = new Select(driver.findElement(By.name("selenium_commands")));
        /** Select option ‘Browser Commands’  and then deselect it (Use selectByIndex and deselectByIndex) */
        multipleSelectBox.selectByIndex(0);
        sleep(2000);
        multipleSelectBox.deselectByIndex(0);
        /** Select option ‘Navigation Commands’  and then deselect it (Use selectByVisibleText and deselectByVisibleText) */
        multipleSelectBox.selectByVisibleText("Navigation Commands");
        sleep(2000);
        multipleSelectBox.deselectByVisibleText("Navigation Commands");
        /** Print and select all the options for the selected Multiple selection list.*/
        List<WebElement> options = multipleSelectBox.getOptions();
        String value;
        for (int i = 0; i < options.size(); i++) {
            value = options.get(i).getText();
            System.out.println("Option: " + value);
            multipleSelectBox.selectByIndex(i);
            sleep(500);
        }
        /** Deselect all options */
        multipleSelectBox.deselectAll();
        closeDriver();
    }


    /**
     *Launch new Browser
     Open DemoQA.com website
     Click on Registration link using “driver.findElement(By.xpath(“.//*[@id=’menu-item-374′]/a”)).click();“
     Come back to Home page (Use ‘Back’ command)
     Again go back to Registration page (This time use ‘Forward’ command)
     Again come back to Home page (This time use ‘To’ command)
     Refresh the Browser (Use ‘Refresh’ command)
     Close the Browser
     */
    public static void navigationExercise(String driverName) {
        //*[@id="menu-item-374"]/a
        driver = DriverFactory.getDriver(driverName);
        String url = "http://demoqa.com/";
        String xpathWithPeriod = ".//*[@id=\"menu-item-374\"]/a";
        driver.get(url);
        driver.findElement(By.xpath(xpathWithPeriod)).click();

        // Go back to Home Page
        driver.navigate().back();

        // Go forward to Registration page
        driver.navigate().forward();

        // Go back to Home page
        driver.navigate().to(url);
        // Refresh browser
        driver.navigate().refresh();

        // Close browser
        driver.close();

    }

    /**
     * Launch a new Firefox browser.
     Open Store.DemoQA.com
     Get Page Title name and Title length
     Print Page Title and Title length on the Eclipse Console.
     Get Page URL and verify if the it is a correct page opened
     Get Page Source (HTML Source code) and Page Source length
     Print Page Length on Eclipse Console.
     Close the Browser.
     */
    public static void practiceExercise1(String driverName) {
        driver = DriverFactory.getDriver(driverName);
        String urlToOpen = "http://store.demoqa.com/";
        driver.get(urlToOpen);
        // Get page title name
        String titleName = driver.getTitle();
        System.out.println("TITLE: " + titleName);
        // Print title length to console
        int titleLength = titleName.length();
        System.out.printf("TITLE LENGTH: %d %n", titleLength);
        // Get Page URL and
        String pageUrl =driver.getCurrentUrl();
        // verify if the it is a correct page opened
        if(pageUrl.equals(urlToOpen)) {
            System.out.println("The page opened is the correct page");
        }else {
            System.out.println("The page opened is not the correct page");
        }

        // Get Page Source (HTML Source code) and Page Source length
        //page source
        String pageSource = driver.getPageSource();
        int lengthPageSource = pageSource.length();
        System.out.printf("The page source length is: %d", lengthPageSource);
        driver.quit();
    }

    /**
     * Practice Exercise – 2
     Launch a new Firefox browser.
     Open http://demoqa.com/frames-and-windows/
     Use this statement to click on a New Window button “driver.findElement(By.xpath(“.//*[@id=’tabs-1′]/div/p/a”)).click();”
     Close the browser using close() command
     */

    public static void practiceExercise2(String driverName) {

        String xpathChrome = "//*[@id=\"tabs-1\"]/div/p/a";
        String xpathFirefox = "/html/body/div[1]/div/div[1]/main/article/div/div/div[1]/div/p/a";
        driver = DriverFactory.getDriver(driverName);
        driver.get("http://demoqa.com/frames-and-windows/");
        driver.findElement(By.xpath(xpathChrome)).click();
        closeDriver();
    }

    /**
     Launch new Browser
     Open URL http://toolsqa.wpengine.com/automation-practice-form/
     Type Name & Last Name (Use Name locator)
     Click on Submit button (Use ID locator)
     */

    public static void practiceFindElementsExercise1(String driverName) {
        driver = DriverFactory.getDriver(driverName);
        String url = "http://toolsqa.wpengine.com/automation-practice-form/";
        String nameInputId = "firstname";
        String lastNameInputId = "lastname";
        driver.get(url);
        WebElement nameInput = driver.findElement(By.name(nameInputId));
        By locator = By.name(lastNameInputId);
        WebElement lastNameInput = driver.findElement(locator);

        String name = "Camilo";
        String lastName = "Posada";

        nameInput.sendKeys(name);
        lastNameInput.sendKeys(lastName);

        driver.findElement(By.id("submit")).click();
        closeDriver();
    }
    /**
     Launch new Browser
     Open “http://toolsqa.wpengine.com/automation-practice-form/“
     Challenge One – Select the deselected Radio button (female) for category Sex (Use IsSelected method)
     Challenge Two – Select the Third radio button for category ‘Years of Exp’ (Use Id attribute to select Radio button)
     Challenge Three – Check the Check Box ‘Automation Tester’ for category ‘Profession'( Use Value attribute to match the selection)
     Challenge Four – Check the Check Box ‘Selenium IDE’ for category ‘Automation Tool’ (Use cssSelector
     */
    public static void practiceCheckBoxesExercice1(String diverName) {
        driver = DriverFactory.getDriver(diverName);
        String url = "http://toolsqa.wpengine.com/automation-practice-form/";
        driver.get(url);
        /** Challenge one */
        List<WebElement> radioButtons = driver.findElements(By.name("sex"));
        boolean isSelected = false;
        WebElement radioButtonFemale = radioButtons.get(0);
        isSelected = radioButtonFemale.isSelected();
        if (isSelected) {
            radioButtonFemale.click();
        }
        /** End challenge one */

        /** Challenge two */
        WebElement radioButton3 = driver.findElement(By.id("exp-2"));
        radioButton3.click();
        /** End challenge two */

        /** Challenge three Check the Check Box ‘Automation Tester’ for category ‘Profession'  ( Use Value attribute to match the selection)*/
        List<WebElement> checkBoxes = driver.findElements(By.name("profession"));
        for (int i = 0; i < checkBoxes.size(); i++) {
            String value = checkBoxes.get(i).getAttribute("value");
            if(value.equalsIgnoreCase("Automation Tester")) {
                checkBoxes.get(i).click();
                break;
            }
        }

        /** End challenge three */

        /** Challenge Four – Check the Check Box ‘Selenium IDE’ for category ‘Automation Tool’ (Use cssSelector */
        WebElement checkBoxSeleniumIDE = driver.findElement(By.cssSelector("input[value='Selenium Webdriver'"));
        checkBoxSeleniumIDE.click();
        /** END challenge four */
        closeDriver();
    }

    private static void getDriver(String driverName) {
        driver = DriverFactory.getDriver(driverName);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
