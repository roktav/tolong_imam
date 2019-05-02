package com.propensi.winscore.repository;

import com.propensi.winscore.model.AdminModel;
import com.propensi.winscore.model.UserModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminDb extends JpaRepository<AdminModel, Long> {
    AdminModel findByUsername(String username);
}
