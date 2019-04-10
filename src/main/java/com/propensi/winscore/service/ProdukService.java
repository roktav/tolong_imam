package com.propensi.winscore.service;

import java.util.ArrayList;
import java.util.List;

import com.propensi.winscore.model.ProdukModel;

import org.springframework.stereotype.Service;

public interface ProdukService {

	ProdukModel addNewProduk(ProdukModel produk);
	ProdukModel updateProduk(ProdukModel produk);
	ProdukModel getProdukById(Long id_produk);
	Boolean deleteProduk(ProdukModel produk);
	List<ProdukModel> findAll();
	public void insert(ProdukModel produk);
    public ArrayList<ProdukModel> getProdukByKategori(String kategori);

}
