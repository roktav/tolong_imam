/*
package com.propensi.winscore.service;

import com.propensi.winscore.model.PembeliModel;
import com.propensi.winscore.model.UserModel;
import com.propensi.winscore.repository.PembeliDb;
import com.propensi.winscore.repository.UserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PembeliServiceImpl implements PembeliService {

    @Autowired
    private PembeliDb pembeliDb;

    @Override
    public List<PembeliModel> getAllUser() {
        return pembeliDb.findAll();
    }


    @Override
    public Optional<PembeliModel> getPembeliById(long id) {
        return pembeliDb.findById(id);
    }
}*/
