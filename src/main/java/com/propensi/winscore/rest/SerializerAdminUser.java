package com.propensi.winscore.rest;

import com.propensi.winscore.model.AdminModel;
import com.propensi.winscore.model.UserModel;

public class SerializerAdminUser {
    private UserModel userModel;
    private AdminModel adminModel;

    public SerializerAdminUser(UserModel userModel, AdminModel adminModel) {
        super();
        this.userModel = userModel;
        this.adminModel = adminModel;

    }

    public AdminModel getAdminModel() {
        return adminModel;
    }

    public void setAdminModel(AdminModel adminModel) {
        this.adminModel = adminModel;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }
}