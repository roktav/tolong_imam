package com.propensi.winscore.service;

import com.propensi.winscore.model.ProdukModel;
import com.propensi.winscore.repository.ProdukRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@Transactional
@Qualifier(value = "ProdukServiceImpl")

public class ProdukServiceImpl implements ProdukService {
    private ProdukRepository repository;

    @Autowired
    public void setRepository(ProdukRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProdukRepository getRepository() {
        return repository;
    }

    @Override
    public ProdukModel addNewProduk(Long id_produk, String nama, String kode_produk, String detail_produk, String status, Long harga){
        ProdukModel produk = new ProdukModel();
        produk.setId_produk(id_produk);
        produk.setNama(nama);
        produk.setKode_produk(kode_produk);
        produk.setDetail_produk(detail_produk);
        produk.setStatus(status);
        produk.setHarga(harga);
        return repository.save(produk);
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
        return getRepository().save(produk);
    }

    @Override
    public ProdukModel getProdukById(Long id_produk){
        return getRepository()
                .findById(id_produk)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id_produk)));
    }
}
