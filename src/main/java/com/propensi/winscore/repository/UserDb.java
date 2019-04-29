package com.propensi.winscore.repository;

import com.propensi.winscore.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDb extends JpaRepository<UserModel, Long> {
    UserModel findByEmail(String email);
    UserModel deleteByEmail(String email);
    UserModel findById(long id);
}

