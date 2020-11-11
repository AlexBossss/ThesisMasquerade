package com.haulmont.thesis.composite.tests.ui.consts;

import com.haulmont.thesis.composite.tests.ui.pages.utils.PageUtils;

public enum Languages {
    ENG("English"),
    RUS("Русский");

    private String value;

    Languages(String value) {
        this.value = value;
    }

    public String getValue() {
        return PageUtils.transferValue(value);
    }
}
