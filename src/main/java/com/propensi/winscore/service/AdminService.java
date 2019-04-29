package com.propensi.winscore.service;

import com.propensi.winscore.model.AdminModel;

import java.util.List;

public interface AdminService {
    AdminModel addNewAdmin(AdminModel adminModel);
    AdminModel updateAdmin(AdminModel adminModel);
    AdminModel getAdminbyUsername(String username);
    /*AdminModel getAdminbyId_Pegawai(long id_pegawai);*/
    void deleteAdmin(AdminModel adminModel);
    List<AdminModel> findAll();
}
