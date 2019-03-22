package com.propensi.winscore.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name= "order")
public class OrderModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_order;

	@OneToOne
	@JoinColumn(name = "id_pembeli",  referencedColumnName="id_pembeli")
	private PembeliModel pembeli;

	@OneToOne
	@JoinColumn(name = "id_teknisi",  referencedColumnName="id_teknisi")
	private TeknisiModel teknisi;
	
	@NotNull
	@Column(name = "tgl_order", nullable = false)
	private Date tgl_order;
	
	@NotNull
	@Column(name = "kategori_produk", nullable = false)
	private String kategori_produk;
	
	@NotNull
	@Column(name = "jenis_bangunan", nullable = false)
	private String jenis_bangunan;

	public long getId_order() {
		return id_order;
	}

	public void setId_order(long id_order) {
		this.id_order = id_order;
	}

	public PembeliModel getPembeli() {
		return pembeli;
	}

	public void setPembeli(PembeliModel pembeli) {
		this.pembeli = pembeli;
	}

	public TeknisiModel getTeknisi() {
		return teknisi;
	}

	public void setTeknisi(TeknisiModel teknisi) {
		this.teknisi = teknisi;
	}

	public Date getTgl_order() {
		return tgl_order;
	}

	public void setTgl_order(Date tgl_order) {
		this.tgl_order = tgl_order;
	}

	public String getKategori_produk() {
		return kategori_produk;
	}

	public void setKategori_produk(String kategori_produk) {
		this.kategori_produk = kategori_produk;
	}

	public String getJenis_bangunan() {
		return jenis_bangunan;
	}

	public void setJenis_bangunan(String jenis_bangunan) {
		this.jenis_bangunan = jenis_bangunan;
	}
}
