package com.propensi.winscore.service;

import java.util.ArrayList;
import java.util.List;

import com.propensi.winscore.model.KabKotaModel;
import com.propensi.winscore.repository.KabKotaDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class KabKotaServiceImpl implements KabKotaService {

    @Autowired
    private KabKotaDb kabKotaDb;

    @Override
    public KabKotaModel getKabKotaById(long id_kabkota) {
        return kabKotaDb.getOne(id_kabkota);
    }

    @Override
    public List<KabKotaModel> getAllKabKota() {
        return kabKotaDb.findAll();
    }

    @Override
    public void insert(KabKotaModel kabKota) {
        kabKotaDb.save(kabKota);
    }

    @Override
    public ArrayList<KabKotaModel> getKabKotaByProvinsi(String nama) {
        ArrayList<KabKotaModel> kabKotaSorted = new ArrayList<KabKotaModel>();
        List<KabKotaModel> listKabKota = getAllKabKota();
        for (KabKotaModel kabKota : listKabKota){
            if (kabKota.getProvinsi().getNama().equalsIgnoreCase(nama)) {
                kabKotaSorted.add(kabKota);
            }
        }
        return kabKotaSorted;
    }
    
}