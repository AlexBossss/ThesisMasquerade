package com.haulmont.thesis.composite.tests.ui.pages.administration.users;

import com.haulmont.masquerade.Wire;
import com.haulmont.masquerade.base.Composite;
import com.haulmont.masquerade.components.Button;
import com.haulmont.masquerade.components.PopupButton;
import com.haulmont.masquerade.components.Table;
import com.haulmont.thesis.composite.tests.ui.consts.CreatePopUpOptions;
import com.haulmont.thesis.composite.tests.ui.pages.administration.users.innerpages.ConfirmModalWindow;
import com.haulmont.thesis.composite.tests.ui.pages.common.CommonFilter;
import com.haulmont.thesis.composite.tests.ui.pages.utils.Page;
import com.haulmont.thesis.composite.tests.ui.pages.utils.PageBinding;
import com.haulmont.thesis.composite.tests.ui.pages.utils.PageManager;
import com.haulmont.thesis.composite.tests.ui.pages.utils.PageUtils;
import lombok.Getter;

import static com.haulmont.masquerade.Conditions.VISIBLE;
import static com.haulmont.masquerade.Selectors.withText;

@Page
public class UserBrowse extends Composite<UserBrowse> {

    @Wire
    @Getter
    private PopupButton createPopupButton;

    @Wire
    @Getter
    private Button importCSV;

    @Wire
    @Getter
    private Button userTableEditBtn;

    @Wire
    @Getter
    private Table usersTable;

    @Wire
    @Getter
    private Button activeDirectorySynchronizeButton;

    @Wire
    @Getter
    private Button userTableRemoveBtn;

    @PageBinding
    private ConfirmModalWindow confirmModalWindow;

    @PageBinding
    private CommonFilter commonFilter;

    public UserEditor createNewUser() {
        createPopupButton.click(CreatePopUpOptions.NEW.getValue());
        return PageManager.getPage(UserEditor.class);
    }

    public UserBrowse findUserByLogin(String login) {
        commonFilter.addCondition(PageUtils.transferValue("Логин"))
                .setTextCondition(login)
                .apply();
        usersTable.getRow(withText(login)).shouldBe(VISIBLE);
        return this;
    }

    public UserBrowse deleteUserByLogin(String login) {
        findUserByLogin(login);
        userTableRemoveBtn.click();
        confirmModalWindow.confirm();
        usersTable.getRow(withText(login)).shouldNot(VISIBLE);
        return this;
    }

}