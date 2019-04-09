package com.propensi.winscore.service;

import java.util.List;

import com.propensi.winscore.model.ProvinsiModel;
import com.propensi.winscore.repository.ProvinsiDb;


import org.springframework.stereotype.Service;

@Service
public interface ProvinsiService {

    ProvinsiModel getProvinsiById(long id_provinsi);
    public List<ProvinsiModel> getAllProvinsi();
    public void insert(ProvinsiModel provinsi);
}