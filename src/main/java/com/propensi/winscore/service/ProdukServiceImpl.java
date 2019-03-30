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
    public ProdukModel addNewProduk(Long id_produk, String namaProduk, String kodeProduk, String detailProduk, String status, Long harga) {
        ProdukModel produk = new ProdukModel();
        produk.setId(id_produk);
        produk.setNamaProduk(namaProduk);
        produk.setKodeProduk(kodeProduk);
        produk.setDetailProduk(detailProduk);
        produk.setKodeProduk(kodeProduk);
        produk.setDetailProduk(detailProduk);
        produk.setStatus(status);
        produk.setHarga(harga);
        return repository.save(produk);
    }

    @Override
    public ProdukModel updateProduk(Long id_produk, String namaProduk, String kodeProduk, String detailProduk, String status, Long harga) {
        final ProdukModel produk = this.getProdukById(id_produk);
        produk.setId(id_produk);
        produk.setNamaProduk(namaProduk);
        produk.setKodeProduk(kodeProduk);
        produk.setDetailProduk(detailProduk);
        produk.setStatus(status);
        produk.setHarga(harga);
        return repository.save(produk);
    }

    @Override
    public ProdukModel getProdukById(Long id_produk) {
        return getRepository().findById(id_produk).orElseThrow(() -> new EntityNotFoundException(Long.toString(id_produk)));
    }

}
