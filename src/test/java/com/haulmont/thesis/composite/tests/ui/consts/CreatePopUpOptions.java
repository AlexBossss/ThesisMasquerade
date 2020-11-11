package com.haulmont.thesis.composite.tests.ui.consts;


import com.haulmont.thesis.composite.tests.ui.pages.utils.PageUtils;

public enum CreatePopUpOptions {
    NEW("Нового"),
    COPY("Копировать");

    private String value;

    CreatePopUpOptions(String value) {
        this.value = value;
    }

    public String getValue() {

        return PageUtils.transferValue(value);
    }
}
