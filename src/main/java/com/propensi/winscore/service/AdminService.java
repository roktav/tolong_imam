package com.propensi.winscore.service;

import com.propensi.winscore.model.AdminModel;
import com.propensi.winscore.model.UserModel;

import java.util.List;

public interface AdminService {
    AdminModel addNewAdmin(AdminModel adminModel);
    AdminModel updateAdmin(AdminModel adminModel);
    AdminModel getAdminbyUsername(String username);
    void deleteAdmin(AdminModel adminModel);
    List<AdminModel> findAll();
}
