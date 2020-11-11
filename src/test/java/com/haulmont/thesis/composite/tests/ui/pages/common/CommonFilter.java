package com.haulmont.thesis.composite.tests.ui.pages.common;

import com.haulmont.masquerade.Wire;
import com.haulmont.masquerade.components.Button;
import com.haulmont.masquerade.components.DateTimeField;
import com.haulmont.masquerade.components.LookupField;
import com.haulmont.masquerade.components.TextField;
import com.haulmont.thesis.composite.tests.ui.pages.utils.PageElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

@PageElement
public class CommonFilter {

    @Getter
    @FindBy(xpath = ".//div[@cuba-id='genericFilter']//div[contains(@class, 'v-filterselect')]")
    private LookupField filterLookupField;

    @Getter
    @FindBy(xpath = ".//div[@cuba-id='ThesisLookupPickerField_ds']")
    private LookupField filterLookupPickerField;

    @Getter
    @FindBy(xpath = ".//input[contains(@class, 'v-textfield')]")
    private TextField filterTextPickerField;

    @Getter
    @FindBy(xpath = ".//div[contains(@class, '-datefield-composition')]")
    private DateTimeField filterDateTimeField;

    @Getter
    @Wire
    private Button search;

    @Getter
    @Wire
    private Button modeAction;

    public CommonFilter addCondition(String value) {
        filterLookupField.setValue(value);
        return this;
    }

    public CommonFilter setTextCondition(String value) {
        filterTextPickerField.setValue(value);
        return this;
    }

    public CommonFilter setLookupPickerCondition(String value) {
        filterLookupPickerField.setValue(value);
        return this;
    }

    public CommonFilter setLookupCondition(String value) {
        filterLookupField.setValue(value);
        return this;
    }

    public CommonFilter apply() {
        search.click();
        return this;
    }
}
