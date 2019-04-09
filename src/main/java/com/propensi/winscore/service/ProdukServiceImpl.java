package com.propensi.winscore.service;

import com.propensi.winscore.model.ProdukModel;
import com.propensi.winscore.repository.ProdukDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional
@Qualifier(value = "ProdukServiceImpl")

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
    public Boolean deleteProduk(ProdukModel produk) {
        produkDb.delete(produk);
        return true;
    }
}
