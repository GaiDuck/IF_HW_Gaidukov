package org.ifellow.gaidukov.IF_HW3.PropertyProcessor;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyProcessor {

    public String getProp(String propertyName) {
        Properties prop = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("user.properties")) {
            prop.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop.getProperty(propertyName);
    }
}