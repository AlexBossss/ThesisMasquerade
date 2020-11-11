package com.haulmont.thesis.composite.tests.ui.pages;

import com.haulmont.masquerade.base.Composite;
import com.haulmont.thesis.composite.tests.ui.pages.common.Header;
import com.haulmont.thesis.composite.tests.ui.pages.utils.Page;

import com.haulmont.thesis.composite.tests.ui.pages.utils.PageBinding;
import lombok.Getter;

@Page
public class MainPage extends Composite {

    @Getter
    @PageBinding
    private Header header;

}
