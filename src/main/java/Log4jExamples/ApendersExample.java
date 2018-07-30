package Log4jExamples;

import org.apache.log4j.*;

public class ApendersExample {
    static Logger mainLogger = LogManager.getLogger(ApendersExample.class.getName());

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        BasicConfigurator.configure();
        ConsoleAppender appender = new ConsoleAppender();
        appender.activateOptions();
        PatternLayout layoutHelper = new PatternLayout();
        layoutHelper.setConversionPattern("%-5p [%t]: %m%n");
        layoutHelper.activateOptions();
        //mainLogger.getAppender("ConsoleAppender").setLayout(layoutHelper);
        appender.setLayout(layoutHelper);
        mainLogger.addAppender(appender);
        //Create a console appender and attach it to our mainLogger
        mainLogger.info("Pattern 1 is displayed like this");
        layoutHelper.setConversionPattern("%C %m%n");
        mainLogger.info("Pattern 2 is displayed like this");

    }
}
