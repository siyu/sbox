import static org.junit.Assert.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class TestExample {
    static Logger logger = LoggerFactory.getLogger(TestExample.class);

    @Before
    public void before() {
        logger.debug("before");
    }

    @After
    public void after() {
        logger.debug("after");
    }

    @Test
    public void first() {
        logger.debug("first");
        assert(true);
    }

    @Test(expected = RuntimeException.class)
    public void second() {
        logger.debug("second");
        throw new RuntimeException("A dreadful error occurred.");
    }
}
