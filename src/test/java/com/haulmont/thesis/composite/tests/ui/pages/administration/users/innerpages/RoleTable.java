package com.haulmont.thesis.composite.tests.ui.pages.administration.users.innerpages;

import com.haulmont.masquerade.Wire;
import com.haulmont.masquerade.base.Composite;
import com.haulmont.masquerade.components.Button;
import com.haulmont.masquerade.components.Table;
import com.haulmont.thesis.composite.tests.ui.pages.administration.users.UserEditor;
import com.haulmont.thesis.composite.tests.ui.pages.utils.Page;
import com.haulmont.thesis.composite.tests.ui.pages.utils.PageManager;

import static com.haulmont.masquerade.Selectors.withText;

@Page
public class RoleTable extends Composite<RoleTable> {

    @Wire
    private Button selectButton;
    @Wire
    private Table rolesTable;


    public RoleTable selectRole(String role) {
        rolesTable.getRow(withText(role))
                .scrollTo()
                .click();
        return this;
    }

    public UserEditor submit() {
        selectButton.click();
        return PageManager.getPage(UserEditor.class);
    }
}
