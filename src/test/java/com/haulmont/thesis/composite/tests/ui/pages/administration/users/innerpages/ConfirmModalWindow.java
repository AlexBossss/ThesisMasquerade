package com.haulmont.thesis.composite.tests.ui.pages.administration.users.innerpages;

import com.haulmont.masquerade.Wire;
import com.haulmont.masquerade.base.Composite;
import com.haulmont.masquerade.components.Button;
import com.haulmont.thesis.composite.tests.ui.pages.utils.PageElement;
import lombok.Getter;

import static com.haulmont.masquerade.Conditions.VISIBLE;

@PageElement
public class ConfirmModalWindow extends Composite {

    @Wire
    @Getter
    private Button optionDialog_yes;

    @Wire
    @Getter
    private Button optionDialog_no;

    @Wire
    @Getter
    private Button optionDialog_ok;

    @Wire
    @Getter
    private Button optionDialog_cancel;

    public void clickYesToCreateEmp() {
        optionDialog_yes.shouldBe(VISIBLE);
        optionDialog_yes.click();
    }

    public void clickNoToCreateEmp() {
        optionDialog_no.shouldBe(VISIBLE);
        optionDialog_no.click();
    }

    public void confirm() {
        optionDialog_ok.shouldBe(VISIBLE);
        optionDialog_ok.click();
    }

    public void cancel() {
        optionDialog_cancel.shouldBe(VISIBLE);
        optionDialog_cancel.click();
    }
}
