package com.haulmont.thesis.composite.tests.ui.tetsts;

import com.haulmont.thesis.composite.tests.TestConfig;
import com.haulmont.thesis.composite.tests.ui.consts.Constant;
import com.haulmont.thesis.composite.tests.ui.pages.utils.PageManager;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Selenide.open;

public abstract class BaseTest {

   @BeforeTest
    public void initLinks() {
        PageManager.run(this);
        open(TestConfig.getProperty(Constant.BASE_PATH));
    }
}
