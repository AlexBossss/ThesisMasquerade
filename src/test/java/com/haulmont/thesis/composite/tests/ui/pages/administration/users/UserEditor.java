package com.haulmont.thesis.composite.tests.ui.pages.administration.users;

import com.haulmont.masquerade.Wire;
import com.haulmont.masquerade.base.Composite;
import com.haulmont.masquerade.components.*;
import com.haulmont.thesis.composite.tests.ui.pages.administration.users.innerpages.AccessGroupModal;
import com.haulmont.thesis.composite.tests.ui.pages.administration.users.innerpages.ConfirmModalWindow;
import com.haulmont.thesis.composite.tests.ui.pages.administration.users.innerpages.RoleTable;
import com.haulmont.thesis.composite.tests.ui.pages.utils.Page;
import com.haulmont.thesis.composite.tests.ui.pages.utils.PageBinding;

import java.util.Arrays;

@Page
public class UserEditor extends Composite<UserEditor> {

    @Wire
    private TextField login;
    @Wire
    private TextField passw;
    @Wire
    private TextField confirmPassw;
    @Wire
    private TextField lastName;
    @Wire
    private TextField firstName;
    @Wire
    private TextField middleName;
    @Wire
    private TextField name;
    @Wire
    private TextField email;
    @Wire
    private TextField position;
    @Wire
    private CheckBox sendWelcomeEmail;
    @Wire(path = {"group", "lookup"})
    private Button groupBtn;
    @Wire
    private CheckBox changePasswordAtNextLogon;
    @Wire
    private Button rolesTableAddBtn;
    @Wire
    private PickerField group;
    @Wire
    private Button windowClose;
    @Wire
    private PickerField employee;
    @Wire
    private Table rolesTable;
    @Wire
    private TextField language;
    @Wire
    private TextField ipMask;
    @Wire
    private CheckBox active;
    @Wire
    private Button windowCommit;

    @PageBinding
    private UserBrowse userBrowse;

    @PageBinding
    private AccessGroupModal accessGroupModal;

    @PageBinding
    private RoleTable roleTable;

    @PageBinding
    private ConfirmModalWindow confirmModalWindow;

    public UserEditor setLogin(String login) {
        this.login.setValue(login);
        return this;
    }

    public UserEditor setPassword(String password) {
        this.passw.setValue(password);
        return this;
    }

    public UserEditor setConfirmPassword(String password) {
        this.confirmPassw.setValue(password);
        return this;
    }

    public UserEditor setFirstName(String name) {
        this.firstName.setValue(name);
        return this;
    }

    public UserEditor setLastName(String lastName) {
        this.lastName.setValue(lastName);
        return this;
    }

    public UserEditor setName(String name) {
        this.name.setValue(name);
        return this;
    }

    public UserEditor setEmail(String email) {
        this.email.setValue(email);
        return this;
    }

    public UserEditor setWelcomeEmail(Boolean welcome) {
        this.sendWelcomeEmail.setChecked(welcome);
        return this;
    }

    public UserEditor setRoles(String... roles) {
        rolesTableAddBtn.click();
        Arrays.stream(roles).forEach(roleTable::selectRole);
        return roleTable.submit();
    }

    public UserEditor setAccessGroup(String group) {
        groupBtn.click();
        return accessGroupModal
                .selectGroup(group)
                .submit();
    }

    public UserBrowse confirmWithoutCreatingEmp() {
        windowCommit.click();
        confirmModalWindow.clickNoToCreateEmp();
        return userBrowse;
    }

    public UserEditor setChangePass(boolean isSet) {
        changePasswordAtNextLogon.setChecked(isSet);
        return this;
    }
}
