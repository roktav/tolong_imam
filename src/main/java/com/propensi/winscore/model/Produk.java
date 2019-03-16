package com.propensi.winscore.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "produk")
public class Produk implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(max = 50)
	@Column(name = "namaProduk", nullable = false)
	private String namaProduk;
	
	@NotNull
	@Size(max = 15)
	@Column(name = "kodeProduk", nullable = false)
	private String kodeProduk;

	@NotNull
	@Size(max = 100)
	@Column(name = "detailProduk", nullable = false)
	private String detailProduk;
	
	@NotNull
	@Size(max = 20)
	@Column(name = "status", nullable = false)
	private String status;
	
	@NotNull
	@Column(name = "harga", nullable = false)
	private Long harga;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNamaProduk() {
		return namaProduk;
	}

	public void setNamaProduk(String namaProduk) {
		this.namaProduk = namaProduk;
	}

	public String getKodeProduk() {
		return kodeProduk;
	}

	public void setKodeProduk(String kodeProduk) {
		this.kodeProduk = kodeProduk;
	}

	public String getDetailProduk() {
		return detailProduk;
	}

	public void setDetailProduk(String detailProduk) {
		this.detailProduk = detailProduk;
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
