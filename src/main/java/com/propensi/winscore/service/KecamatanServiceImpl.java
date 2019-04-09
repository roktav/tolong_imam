package com.propensi.winscore.service;

import java.util.ArrayList;
import java.util.List;

import com.propensi.winscore.model.KecamatanModel;
import com.propensi.winscore.repository.KecamatanDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class KecamatanServiceImpl implements KecamatanService {

    @Autowired
    private KecamatanDb kecamatanDb;

    @Override
    public KecamatanModel getKecamatanById(long id_kecamatan) {
        return kecamatanDb.getOne(id_kecamatan);
    }

    @Override
    public List<KecamatanModel> getAllKecamatan() {
        return kecamatanDb.findAll();
    }

    @Override
    public void insert(KecamatanModel kecamatan) {
        kecamatanDb.save(kecamatan);
    }

    @Override
    public ArrayList<KecamatanModel> getKecamatanByKabKota(String nama) {
        ArrayList<KecamatanModel> kecamatanSorted = new ArrayList<KecamatanModel>();
        List<KecamatanModel> listKecamatan = getAllKecamatan();
        for (KecamatanModel kecamatan : listKecamatan){
            if (kecamatan.getKabkota().getNama().equalsIgnoreCase(nama)) {
                kecamatanSorted.add(kecamatan);
            }
        }
        return kecamatanSorted;
    }
    
}