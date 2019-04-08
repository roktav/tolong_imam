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
    public ProdukModel updateProduk(Long id_produk, String nama, String kode_produk, String detail_poduk, String status, Long harga){
        final ProdukModel produk = this.getProdukById(id_produk);
        produk.setId_produk(id_produk);
        produk.setNama(nama);
        produk.setKode_produk(kode_produk);
        produk.setDetail_produk(detail_poduk);
        produk.setStatus(status);
        produk.setHarga(harga);
        return getProdukDb().save(produk);
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
}
