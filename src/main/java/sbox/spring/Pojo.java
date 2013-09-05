package sbox.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Pojo {
    private String stringField;
    private Integer integerField;

    public Pojo(String aString, Integer anInteger) {
        stringField = aString;
        integerField = anInteger;
    }

    public String getStringField() {
        return stringField;
    }

    public Integer getIntegerField() {
        return integerField;
    }

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Pojo.class);
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Pojo pojo = (Pojo) context.getBean("pojo");
        logger.debug("pojo: stringField: " + pojo.getStringField() +
          " integerField: " + pojo.getIntegerField());
    }
}
