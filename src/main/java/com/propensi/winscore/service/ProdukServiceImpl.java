package com.propensi.winscore.service;

import java.util.ArrayList;
import java.util.List;

import com.propensi.winscore.model.ProdukModel;
import com.propensi.winscore.repository.ProdukDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@Transactional
public class ProdukServiceImpl implements ProdukService {

    @Autowired
    private ProdukDb produkDb;

    public ProdukDb getProdukDb() {
        return produkDb;
    }

    public void setProdukDb(ProdukDb produkDb) {
        this.produkDb = produkDb;
    }

    @Override
    public ProdukModel addNewProduk(ProdukModel produk) {

        return produkDb.save(produk);
    }

    @Override
    public ProdukModel updateProduk(ProdukModel produk){

        return produkDb.save(produk);
    }

    @Override
    public ProdukModel getProdukById(Long id_produk){
        return getProdukDb()
                .findById(id_produk)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id_produk)));
    }

    @Override
    public List<ProdukModel> findAll() {
        return produkDb.findAll();
    }

    @Override
    public void insert(ProdukModel produk) {
        produkDb.save(produk);
    }

    @Override
    public ArrayList<ProdukModel> getProdukByKategori(String kategori) {
        System.out.println("Masuk method sort");
        ArrayList<ProdukModel> produkSorted = new ArrayList<ProdukModel>();
        List<ProdukModel> produkList = produkDb.findAll();
        System.out.println("produkList = null");
        System.out.println(produkList);
        for (ProdukModel produk : produkList){
            if (produk.getKategori_produk().equalsIgnoreCase(kategori)) {
                produkSorted.add(produk);
            }
        }
        return produkSorted;
    }

    @Override
    public Boolean deleteProduk(ProdukModel produk) {
        produkDb.delete(produk);
        return true;
    }
}
