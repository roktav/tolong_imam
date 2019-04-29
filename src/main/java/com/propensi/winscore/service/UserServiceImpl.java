package com.propensi.winscore.service;

import com.propensi.winscore.model.UserModel;
import com.propensi.winscore.repository.UserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDb userDb;

    @Override
    public UserModel addUser(UserModel user) {
        String pass = user.getPassword();
        user.setPassword(pass);
        return userDb.save(user);
    }

    /*@Override
    public String encrypt(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }*/

    @Override
    public UserModel getUserByEmail(String email) {
        return userDb.findByEmail(email);
    }

    @Override
    public UserModel getUserById(long id_user) {
        return userDb.findById(id_user);
    }

    @Override
    public List<UserModel> getUserRoleList() {
        return userDb.findAll();
    }

    @Override
    public void deleteUser(UserModel userModel) {
        userDb.delete(userModel);
    }
}
