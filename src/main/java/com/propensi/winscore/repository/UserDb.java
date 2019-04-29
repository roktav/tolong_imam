package com.propensi.winscore.repository;

import com.propensi.winscore.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDb extends JpaRepository<UserModel, Long> {
    UserModel findByEmail(String email);
    UserModel deleteByEmail(String email);
    UserModel findById(long id);

//    List<UserModel> findByIdIn(List<Long> userIds);

    Boolean existsByEmail(String email);
}

