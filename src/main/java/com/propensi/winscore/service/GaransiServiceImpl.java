package com.propensi.winscore.service;

import com.propensi.winscore.model.GaransiModel;
import com.propensi.winscore.repository.GaransiDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@Transactional
@Qualifier(value = "GaransiServiceImpl")

public class GaransiServiceImpl implements GaransiService{

    @Autowired
    private GaransiDb garansiDb;

    public GaransiDb getGaransiDb() {
        return garansiDb;
    }

    public void setGaransiDb(GaransiDb garansiDb) {
        this.garansiDb = garansiDb;
    }

    @Override
    public GaransiModel addNewGaransi(GaransiModel garansi) {
        return garansiDb.save(garansi);
    }

    @Override
    public GaransiModel getGaransiById(Long id_garansi) {
        return getGaransiDb()
                .findById(id_garansi)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id_garansi)));
    }
}
