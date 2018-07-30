import exercises.DragAndDrop;
import exercises.MouseHover;
import exercises.SwitchCommands;
import exercises.Waits;
import org.openqa.selenium.support.ui.Wait;
import utiles.Util;


public class App {

    /** Menu constants */
    private static final char EXIT = 'q';
    private static final char CHANGE_DRIVER = 'd';
    private static final char RETURN = 'r';

    private static final String FIREFOX = "FIREFOX";
    private static final String CHROME = "CHROME";
    private static String driversName;
    /** End of constants */

    public static void main(String[] args) {
        char option;
        boolean close = false;
        driversName = "CHROME";

        //setDriverForFirefox();
        //serDriverForChrome();

        while(!close) {
            showMenu();
            try {
                option = Util.readChar("Enter option");

                switch (option) {
                    case '1':
                        Exercices.practiceExercise1(driversName);
                        break;
                    case '2':
                        Exercices.practiceExercise2(driversName);
                        break;
                    case '3':
                        Exercices.navigationExercise(driversName);
                        break;
                    case '4':
                        Exercices.practiceFindElementsExercise1(driversName);
                        break;
                    case '5':
                        Exercices.practiceCheckBoxesExercice1(driversName);
                        break;
                    case '6':
                        Exercices.dropDownSelectExercice1(driversName);
                        break;
                    case '7':
                        Exercices.dropDownSelectExercice2(driversName);
                        break;
                    case '8':
                        Exercices.tablesExercise1(driversName);
                        break;
                    case '9':
                        Exercices.tablesExercise2(driversName);
                        break;
                    case 'w':
                        Exercices.tablesExercise2(driversName);
                        break;
                    case 'f':
                        Waits.fluentWait1(driversName);
                        break;
                    case 'g':
                        Waits.fluentWait2(driversName);
                        break;
                    case 's':
                        SwitchCommands.switchExercise1(driversName);
                        break;
                    case 'x':
                        SwitchCommands.switchExercise2_2(driversName);
                        break;
                    case 'v':
                        DragAndDrop.dragAndDrop1(driversName);
                        break;
                    case 'm':
                        MouseHover.mouseHover(driversName);
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
                        System.out.println("Enter a valid option");
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

    private static void showMenu() {
        System.out.println("**** SELENIUM WEB DRIVER *******");
        System.out.println("-- EJERCICIOS --");
        System.out.println("1) Practice Exercise – 1");
        System.out.println("2) Practice Exercise – 2");
        System.out.println("3) Practice Navigation Exercise – 1");
        System.out.println("4) Practice find elements Exercise – 1");
        System.out.println("5) Practice radio buttons - check boxes Exercise – 1");
        System.out.println("6) Practice Drops downs and selects Exercise – 1");
        System.out.println("7) Practice Drops downs and selects Exercise – 2");
        System.out.println("8) Tables - Exercise - 1");
        System.out.println("9) Tables - Exercise - 2");
        System.out.println("z) FLUENT WAIT - COLOR");
        System.out.println("g) FLUENT WAIT - ELEMENT");
        System.out.println("f) WAIT EXERCISE");
        System.out.println("s) SWITCH EXERCISES -- 1 ");
        System.out.println("x) SWITCH EXERCISES -- 2 ");
        System.out.println("v) DRAG AND DROP ");
        System.out.println("m) MOUSE DRIVER ");
        System.out.println(CHANGE_DRIVER + ") Change driver");
        System.out.println(EXIT + ") Exit");
    }
}
