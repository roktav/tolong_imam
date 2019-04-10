package com.propensi.winscore.service;

import java.util.List;

import com.propensi.winscore.model.UserModel;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
    List<UserModel> getAllUser();
}