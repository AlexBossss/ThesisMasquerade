package com.haulmont.thesis.composite.tests;

import com.haulmont.thesis.composite.tests.ui.consts.Constant;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestConfig {
    private static Properties properties = new Properties();

    static {
        try (InputStream inputStream = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream(Constant.PROPERTY_PATH.getValue())) {

            if (inputStream == null) throw new NullPointerException("No inputStream!");

            properties.load(inputStream);
        } catch (IOException e) {
            throw new IllegalStateException("FATAL! Cannot read " + Constant.PROPERTY_PATH + "!");
        }
    }

    public static String getProperty(Constant constant) {
        return properties.getProperty(constant.getValue());
    }

}
