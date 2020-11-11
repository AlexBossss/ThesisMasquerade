package com.haulmont.thesis.composite.tests.ui.consts;

public enum Constant {
    PROPERTY_PATH("test.properties"),
    BASE_PATH("baseUrl"),
    PACKAGE_PATH("com.haulmont.thesis.composite"),
    ADMIN_LOGIN("adminLogin"),
    ADMIN_PASS("adminPass");
    private String value;

    Constant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
