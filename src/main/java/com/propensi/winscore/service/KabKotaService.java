package com.propensi.winscore.service;

import java.util.List;

import com.propensi.winscore.model.KabKotaModel;

import org.springframework.stereotype.Service;

@Service
public interface KabKotaService {

    KabKotaModel getKabKotaById(long id_kabkota);
    public List<KabKotaModel> getAllKabKota();
    public void insert(KabKotaModel kabKota);
    public List<KabKotaModel> getKabKotaByProvinsi(String nama);

}