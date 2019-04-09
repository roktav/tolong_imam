package com.propensi.winscore.service;

import java.util.ArrayList;
import java.util.List;

import com.propensi.winscore.model.ProdukModel;
import com.propensi.winscore.repository.ProdukDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Qualifier
@Service
@Transactional
public class ProdukServiceImpl implements ProdukService {

    @Autowired
    private ProdukDb produkDb;

    @Override
    public ProdukModel getProdukById(long id_produk) {
        return produkDb.getOne(id_produk);
    }

    @Override
    public List<ProdukModel> getAllProduk() {
        return produkDb.findAll();
    }

    @Override
    public void insert(ProdukModel produk) {
        produkDb.save(produk);
    }

    @Override
    public ArrayList<ProdukModel> getProdukByKategori(String kategori) {
        ArrayList<ProdukModel> produkSorted = new ArrayList<ProdukModel>();
        List<ProdukModel> produkList = produkDb.findAll();
        for (ProdukModel produk : produkList){
            if (produk.getKategori().equalsIgnoreCase(kategori)) {
                produkSorted.add(produk);
            }
        }
        return produkSorted;
    }

}
