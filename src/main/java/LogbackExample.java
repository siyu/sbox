import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackExample {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(LogbackExample.class);
        logger.debug("logback");
    }
}
