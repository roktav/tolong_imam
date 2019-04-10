package com.propensi.winscore.service;

import java.util.List;

import com.propensi.winscore.model.ProvinsiModel;
import com.propensi.winscore.repository.ProvinsiDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProvinsiServiceImpl implements ProvinsiService {

    @Autowired
    private ProvinsiDb provinsiDb;

    @Override
    public ProvinsiModel getProvinsiById(long id_provinsi) {
        return provinsiDb.getOne(id_provinsi);
    }

    @Override
    public List<ProvinsiModel> getAllProvinsi() {
        return provinsiDb.findAll();
    }

    @Override
    public void insert(ProvinsiModel provinsi) {
        provinsiDb.save(provinsi);

    }

    
    
}