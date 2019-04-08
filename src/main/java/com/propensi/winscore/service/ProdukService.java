package com.propensi.winscore.service;

import com.propensi.winscore.model.ProdukModel;

import java.util.List;

public interface ProdukService {

	ProdukModel addNewProduk(ProdukModel produk);
	ProdukModel updateProduk(ProdukModel produk);
	ProdukModel getProdukById(Long id_produk);
	List<ProdukModel> findAll();

}
