package com.blogcms.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
    private static Configuration instance;
    private final Properties properties;

    private Configuration() {
        properties = new Properties();
        try {
            FileInputStream file = new FileInputStream("src/test/resources/config.properties");
            properties.load(file);
        } catch (IOException e) {
            throw new RuntimeException("Could not load config.properties file", e);
        }
    }

    public static Configuration getInstance() {
        if (instance == null) {
            instance = new Configuration();
        }
        return instance;
    }

    public String getBaseUrl() {
        return properties.getProperty("base.url");
    }

    public int getExplicitTimeout() {
        return Integer.parseInt(properties.getProperty("timeout.explicit"));
    }

    public String getValidEmail() {
        return properties.getProperty("login.valid.email");
    }

    public String getValidPassword() {
        return properties.getProperty("login.valid.password");
    }

    public String getInvalidEmail() {
        return properties.getProperty("login.invalid.email");
    }

    public String getInvalidPassword() {
        return properties.getProperty("login.invalid.password");
    }
} 