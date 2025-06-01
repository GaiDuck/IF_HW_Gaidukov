package org.ifellow.gaidukov.IF_HW3.features;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyProcessor {

    public String getProp(String propertyName, String propertyType) {

        Properties prop = new Properties();
        String propertyFileName = null;

        if (propertyType == "USER") {
            propertyFileName = "user.properties";
        } else if (propertyType == "ALLURE") {
            propertyFileName = "allure.properties";
        }

        try (InputStream input = getClass().getClassLoader().getResourceAsStream(propertyFileName)) {
            prop.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop.getProperty(propertyName);
    }
}