import driverFactory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import utiles.Util;

public class App {
    private static WebDriver driver;

    /** Menu constants */
    private static final char EXIT = 'q';
    private static final char CHANGE_DRIVER = 'd';
    private static final char RETURN = 'r';

    private static final String FIREFOX = "FIREFOX";
    private static final String CHROME = "CHROME";
    private static String driversName;
    public static void main(String[] args) {
        char option;
        boolean close = false;

        //setDriverForFirefox();
        //serDriverForChrome();

        while(!close) {
            showMenu();
            try {
                option = Util.readChar("Enter option");

                switch (option) {
                    case '1':
                        practiceExercise1(driversName);
                        break;
                    case '2':
                        practiceExercise2(driversName);
                        break;
                    case '3':
                        navigationExercise(driversName);
                        break;
                    case CHANGE_DRIVER:
                        showChangeDriverMenu();
                        break;
                    case EXIT:
                        close = true;
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private static void showChangeDriverMenu() {
        int opt;
        boolean show = true;
        while (show) {
            changeDriverMenu();
            try {
                opt = Util.readChar("ENTER OPTION: ");
                switch (opt) {
                    case '1':
                        driversName = CHROME;
                        show = false;
                        break;
                    case '2':
                        driversName = FIREFOX;
                        show = false;
                        break;
                    case RETURN:
                        show = false;
                        break;
                    default:
                        System.out.printf("Enter a valid option");
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private static void changeDriverMenu() {
        System.out.println("**** CHANGE SELENIUM WEB DRIVER *******");
        System.out.println("-- DRIVERS --");
        System.out.println("1) CHROME");
        System.out.println("2) FIREFOX");
        System.out.println(RETURN  + ") RETURN");
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
    private static void navigationExercise(String driverName) {
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
     private static void practiceExercise1(String driverName) {
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

        /* try {
             Thread.sleep(5000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }*/
         driver.quit();
     }

    /**
     * Practice Exercise – 2
        Launch a new Firefox browser.
        Open http://demoqa.com/frames-and-windows/
        Use this statement to click on a New Window button “driver.findElement(By.xpath(“.//*[@id=’tabs-1′]/div/p/a”)).click();”
        Close the browser using close() command
     */

     private static void practiceExercise2(String driverName) {

         String xpathChrome = "//*[@id=\"tabs-1\"]/div/p/a";
         String xpathFirefox = "/html/body/div[1]/div/div[1]/main/article/div/div/div[1]/div/p/a";
         driver = DriverFactory.getDriver(driverName);
         driver.get("http://demoqa.com/frames-and-windows/");
         driver.findElement(By.xpath(xpathChrome)).click();
         try {
             Thread.sleep(5000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         driver.close();
     }

     private static void showMenu() {
         System.out.println("**** SELENIUM WEB DRIVER *******");
         System.out.println("-- EJERCICIOS --");
         System.out.println("1) Practice Exercise – 1");
         System.out.println("2) Practice Exercise – 2");
         System.out.println("3) Practice Navigation Exercise – 1");
         System.out.println(CHANGE_DRIVER + ") Change driver");
         System.out.println(EXIT + ") Exit");

     }
}
