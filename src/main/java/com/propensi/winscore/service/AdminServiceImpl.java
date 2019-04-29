package com.propensi.winscore.service;

import java.util.List;

import com.propensi.winscore.model.AdminModel;
import com.propensi.winscore.repository.AdminDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDb adminDb;

    public AdminDb getAdminDb() {
        return adminDb;
    }

    @Override
    public AdminModel addNewAdmin(AdminModel adminModel) {
        return adminDb.save(adminModel);
    }

    @Override
    public AdminModel updateAdmin(AdminModel adminModel) {
        return adminDb.save(adminModel);
    }

    @Override
    public AdminModel getAdminbyUsername(String username) {
        return getAdminDb().findByUsername(username);
    }

    /*@Override
    public AdminModel getAdminbyId_Pegawai(long id_pegawai) {
        return adminDb.findById_pegawai(id_pegawai);
    }*/

    @Override
    public void deleteAdmin(AdminModel adminModel) {
        adminDb.delete(adminModel);
    }

    @Override
    public List<AdminModel> findAll() {
        return adminDb.findAll();
    }
}
