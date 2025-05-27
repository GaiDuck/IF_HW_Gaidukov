package org.ifellow.gaidukov.IF_HW5;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyProcesser {

    public String getProp(String propertyName) {
        Properties prop = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            prop.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop.getProperty(propertyName);
    }
}
