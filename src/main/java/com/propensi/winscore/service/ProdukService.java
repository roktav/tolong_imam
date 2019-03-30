package com.propensi.winscore.service;

import com.propensi.winscore.model.ProdukModel;
import com.propensi.winscore.repository.ProdukRepository;

public interface ProdukService extends Service<ProdukRepository>{

	ProdukModel addNewProduk(Long id_produk, String namaProduk, String kodeProduk, String detailProduk, String status, Long harga);
	ProdukModel updateProduk(Long id_produk, String namaProduk, String kodeProduk, String detailProduk, String status, Long harga);
	ProdukModel getProdukById(Long id_produk);
}
