package com.haulmont.thesis.composite.tests.ui.pages;

import com.haulmont.masquerade.Wire;
import com.haulmont.masquerade.base.Composite;
import com.haulmont.masquerade.components.Button;
import com.haulmont.masquerade.components.CheckBox;
import com.haulmont.masquerade.components.LookupField;
import com.haulmont.masquerade.components.TextField;
import com.haulmont.thesis.composite.tests.ui.consts.Languages;
import com.haulmont.thesis.composite.tests.ui.pages.utils.Page;
import com.haulmont.thesis.composite.tests.ui.pages.utils.PageBinding;
import lombok.Getter;

import static com.haulmont.masquerade.Conditions.VISIBLE;

@Page
public class LoginPage extends Composite {

    @Wire
    @Getter
    private TextField loginField;

    @Wire
    @Getter
    private TextField passwordField;

    @Wire
    @Getter
    private LookupField localesField;

    @Wire
    @Getter
    private CheckBox rememberMeCheckBox;

    @Wire
    @Getter
    private Button loginSubmitButton;

    @PageBinding
    private MainPage mainPage;

    public MainPage login(String login, String password) {
        return setLoginField(login)
                .setPasswordField(password)
                .enter();
    }

    public LoginPage setLoginField(String login) {
        loginField.setValue(login);
        return this;
    }

    public LoginPage setPasswordField(String password) {
        passwordField.setValue(password);
        return this;
    }

    public LoginPage setLanguage(Languages languages) {
        localesField
                .openOptionsPopup()
                .select(languages.getValue());
        return this;
    }

    public LoginPage setRememberMeCheckBox(boolean b) {
        rememberMeCheckBox.setChecked(b);
        return this;
    }

    public MainPage enter() {
        loginSubmitButton.click();
        mainPage
                .getHeader()
                .shouldBe(VISIBLE);
        return mainPage;
    }
}


