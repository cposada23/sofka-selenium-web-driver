package Log4jExamples;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Sample1 {
    static Logger logger = LogManager.getLogger(Sample1.class.getName());
    public static void main(String[] args) {
        BasicConfigurator.configure();
        logger.info("This is logger info");
    }
}
