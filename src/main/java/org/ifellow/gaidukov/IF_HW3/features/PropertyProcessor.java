package org.ifellow.gaidukov.IF_HW3.features;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyProcessor {

    public String getProp(String propertyName, String propertyType) {

        Properties prop = new Properties();
        String propertyFileName = null;

        switch (propertyType) {
            case "USER" -> propertyFileName = "user.properties";
            case "ALLURE" -> propertyFileName = "allure.properties";
            case "TASK" -> propertyFileName = "task.properties";
            case "TEST_TASK" -> propertyFileName = "testTask.properties";
            default -> throw new RuntimeException();
        }

        try (InputStream input = getClass().getClassLoader().getResourceAsStream(propertyFileName)) {
            prop.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return prop.getProperty(propertyName);
    }
}