package com.haulmont.thesis.composite.tests.ui.tetsts;

import com.haulmont.thesis.composite.tests.TestConfig;
import com.haulmont.thesis.composite.tests.ui.consts.Constant;
import com.haulmont.thesis.composite.tests.ui.pages.LoginPage;
import com.haulmont.thesis.composite.tests.ui.pages.common.Header;
import com.haulmont.thesis.composite.tests.ui.pages.utils.PageBinding;
import org.testng.annotations.Test;

public class CreateUserTest extends BaseTest {

    @PageBinding
    private LoginPage loginPage;

    @PageBinding
    private Header header;

    private static final String login = "TEST_USER2";
    private static final String pass = "1";

    @Test
    public void runCreateUserTest() {

        loginPage.login(
                TestConfig.getProperty(Constant.ADMIN_LOGIN),
                TestConfig.getProperty(Constant.ADMIN_PASS)
        )
                .getHeader()
                .clickAdministration()
                .clickUsers()
                .createNewUser()
                .setLogin(login)
                .setPassword(pass)
                .setChangePass(false)
                .setConfirmPassword(pass)
                .setWelcomeEmail(false)
                .setAccessGroup("Ограниченный доступ")
                .setRoles("doc_initiator", "doc_secretary", "doc_endorsement")
                .confirmWithoutCreatingEmp()
                .deleteUserByLogin(login);

        header
                .logout();
    }
}
