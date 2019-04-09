package com.propensi.winscore.service;

import java.util.ArrayList;
import java.util.List;

import com.propensi.winscore.model.KabKotaModel;
import com.propensi.winscore.model.ProdukModel;

import org.springframework.stereotype.Service;

@Service
public interface ProdukService {

    ProdukModel getProdukById(long id_produk);
    List<ProdukModel> getAllProduk();
    public void insert(ProdukModel produk);
    public ArrayList<ProdukModel> getProdukByKategori(String kategori);

}
