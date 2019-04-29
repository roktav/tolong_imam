package com.propensi.winscore.service;

import com.propensi.winscore.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel addUser(UserModel user);
    UserModel getUserByEmail(String email);
    UserModel getUserById(long id);
    List<UserModel> getUserRoleList();
    void deleteUser(UserModel userModel);
}
