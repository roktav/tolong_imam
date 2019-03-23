package com.propensi.winscore.service;

import com.propensi.winscore.model.ProdukModel;

public interface ProdukService{

	ProdukModel addNewProduk(Long id_produk);
	ProdukModel updateProduk(Long id_produk, String namaProduk, String kodeProduk, String detailProduk, String status, Long harga);
}
