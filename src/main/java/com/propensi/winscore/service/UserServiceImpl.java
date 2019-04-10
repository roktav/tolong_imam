package com.propensi.winscore.service;

import java.util.List;

import com.propensi.winscore.model.UserModel;
import com.propensi.winscore.repository.UserDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDb userDb;

    @Override
    public List<UserModel> getAllUser() {
        return userDb.findAll();
    }
    
}