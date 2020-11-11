package com.haulmont.thesis.composite.tests.ui.pages.utils;

import java.io.UnsupportedEncodingException;

public class PageUtils {
    public static String transferValue(String value) {
        try {
            return new String(value.getBytes("windows-1251"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return value;
    }
}
