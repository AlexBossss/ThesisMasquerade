package com.haulmont.thesis.composite.tests.ui.tetsts;

import com.haulmont.thesis.composite.tests.TestConfig;
import com.haulmont.thesis.composite.tests.ui.consts.Constant;
import com.haulmont.thesis.composite.tests.ui.pages.LoginPage;
import com.haulmont.thesis.composite.tests.ui.pages.common.Header;
import com.haulmont.thesis.composite.tests.ui.pages.utils.PageBinding;
import org.testng.annotations.Test;

import static com.haulmont.masquerade.Conditions.*;

public class LoginPageTest extends BaseTest {

    @PageBinding
    LoginPage loginPage;

    @PageBinding
    Header header;

    @Test
    public void run() {

        loginPage.getLoginField()
                .shouldBe(EDITABLE)
                .shouldBe(ENABLED);

        loginPage.getPasswordField()
                .shouldBe(EDITABLE)
                .shouldBe(ENABLED);

        loginPage.getLocalesField()
                .shouldBe(VISIBLE);

        loginPage.getRememberMeCheckBox()
                .shouldBe(VISIBLE)
                .shouldBe(ENABLED);

        loginPage.getLoginSubmitButton()
                .shouldBe(VISIBLE)
                .shouldBe(ENABLED);

        loginPage.login(
                TestConfig.getProperty(Constant.ADMIN_LOGIN),
                TestConfig.getProperty(Constant.ADMIN_PASS)
        )
                .getHeader()
                .logout();
    }
}
