package com.propensi.winscore.service;

import java.util.ArrayList;
import java.util.List;

import com.propensi.winscore.model.KecamatanModel;

import org.springframework.stereotype.Service;

@Service
public interface KecamatanService {
    
    KecamatanModel getKecamatanById(long id_kecamatan);
    List<KecamatanModel> getAllKecamatan();
    public void insert(KecamatanModel kecamatan);
    public ArrayList<KecamatanModel> getKecamatanByKabKota(String nama);
}