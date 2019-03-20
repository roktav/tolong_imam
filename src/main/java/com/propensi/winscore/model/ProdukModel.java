package com.propensi.winscore.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "produk")
public class ProdukModel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_produk;

	@OneToOne
	@JoinColumn(name = "id_garansi")
	private long id_garansi;

	@OneToOne
	@JoinColumn(name = "id_promosi")
	private long id_promosi;

	@NotNull
	@Size(max = 50)
	@Column(name = "nama", nullable = false)
	private String nama;
	
	@NotNull
	@Size(max = 15)
	@Column(name = "kode_produk", nullable = false)
	private String kode_produk;

	@NotNull
	@Size(max = 100)
	@Column(name = "detail_produk", nullable = false)
	private String detail_produk;
	
	@NotNull
	@Size(max = 20)
	@Column(name = "status", nullable = false)
	private String status;
	
	@NotNull
	@Column(name = "harga", nullable = false)
	private Long harga;
	
	public Long getId() {
		return id_produk;
	}

	public void setId(Long id_produk) {
		this.id_produk = id_produk;
	}

	public String getNamaProduk() {
		return nama;
	}

	public void setNamaProduk(String namaProduk) {
		this.nama = namaProduk;
	}

	public String getKodeProduk() {
		return kode_produk;
	}

	public void setKodeProduk(String kodeProduk) {
		this.kode_produk = kodeProduk;
	}

	public String getDetailProduk() {
		return detail_produk;
	}

	public void setDetailProduk(String detailProduk) {
		this.detail_produk = detailProduk;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getHarga() {
		return harga;
	}

	public void setHarga(Long harga) {
		this.harga = harga;
	}

}
