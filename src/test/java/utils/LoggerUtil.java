package utils;


import org.apache.log4j.Logger;

public class LoggerUtil {

    public final static Logger logger = Logger.getLogger(LoggerUtil.class.getName());

    public static void step(int stepNumber) {
        step(stepNumber, "Is processing");
    }

    public static void step(int stepNumber, String stepName) {
        logger.info(String.format("\nStep [%d] - %s", stepNumber, stepName));
    }
}
