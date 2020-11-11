package com.haulmont.thesis.composite.tests.ui.pages.common;

import com.haulmont.masquerade.Wire;
import com.haulmont.masquerade.base.Composite;
import com.haulmont.masquerade.components.Button;
import com.haulmont.thesis.composite.tests.ui.pages.LoginPage;
import com.haulmont.thesis.composite.tests.ui.pages.administration.users.UserBrowse;

import com.haulmont.thesis.composite.tests.ui.pages.utils.PageBinding;
import com.haulmont.thesis.composite.tests.ui.pages.utils.PageElement;
import com.haulmont.thesis.composite.tests.ui.pages.utils.PageManager;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

import static com.haulmont.masquerade.Conditions.VISIBLE;

@PageElement
public class Header extends Composite<Header> {

    @Wire
    @Getter
    private Button administration;

    @Wire
    @Getter
    private Button logoutButton;

    @FindBy(xpath = "//span[@cuba-id='sec$User.browse']")
    @Getter
    private Button users;

    @PageBinding
    private LoginPage loginPage;

    public Header clickAdministration() {
        administration.shouldBe(VISIBLE);
        administration.click();
        return this;
    }

    public UserBrowse clickUsers() {
        users.shouldBe(VISIBLE);
        users.click();
        return PageManager.getPage(UserBrowse.class);
    }

    public LoginPage logout() {
        logoutButton.click();
        loginPage.shouldBe(VISIBLE);
        return loginPage;
    }
}
