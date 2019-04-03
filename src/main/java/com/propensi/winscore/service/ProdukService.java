package com.propensi.winscore.service;

import com.propensi.winscore.model.ProdukModel;

import java.util.List;

public interface ProdukService {

	ProdukModel addNewProduk(Long id_produk, String nama, String kode_produk, String detail_produk, String status, Long harga);
	ProdukModel updateProduk(Long id_produk, String nama, String kode_produk, String detail_poduk, String status, Long harga);
	ProdukModel getProdukById(Long id_produk);
	List<ProdukModel> findAll();
}
