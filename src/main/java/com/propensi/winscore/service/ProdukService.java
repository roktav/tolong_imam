package com.propensi.winscore.service;

import com.propensi.winscore.model.ProdukModel;
import com.propensi.winscore.repository.ProdukRepository;

public interface ProdukService extends Service<ProdukRepository>{

	ProdukModel addNewProduk(Long id_produk, String nama, String kode_produk, String detail_produk, String status, Long harga);
	ProdukModel updateProduk(Long id_produk, String nama, String kode_produk, String detail_poduk, String status, Long harga);
	ProdukModel getProdukById(Long id_produk);
}
