package com.haulmont.thesis.composite.tests.ui.pages.administration.users.innerpages;

import com.haulmont.masquerade.Wire;
import com.haulmont.masquerade.base.Composite;
import com.haulmont.masquerade.components.Button;
import com.haulmont.thesis.composite.tests.ui.pages.administration.users.UserEditor;
import com.haulmont.thesis.composite.tests.ui.pages.utils.Page;
import com.haulmont.thesis.composite.tests.ui.pages.utils.PageManager;
import com.haulmont.thesis.composite.tests.ui.pages.utils.PageUtils;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Page
public class AccessGroupModal extends Composite<AccessGroupModal> {
    @Wire
    private Button selectButton;

    public AccessGroupModal selectGroup(String groupName) {
        $(By.xpath(
                String.format(
                        "//span[text()='%s']",
                        PageUtils.transferValue(groupName))
                )
        )
                .click();
        return this;
    }

    public UserEditor submit() {
        selectButton.click();
        return PageManager.getPage(UserEditor.class);
    }
}
