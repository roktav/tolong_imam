package com.propensi.winscore.repository;

import com.propensi.winscore.model.AdminModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminDb extends JpaRepository<AdminModel, Long> {
    AdminModel findByUsername(String username);
    /*AdminModel findById_pegawai(long id_pegawai);*/
}
