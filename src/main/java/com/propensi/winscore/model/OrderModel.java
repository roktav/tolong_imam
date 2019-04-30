package com.propensi.winscore.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name= "`order`")
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
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date tgl_order;

	@NotNull
	@Column(name = "kategori_produk", nullable = false)
	private String kategori_produk;

	@NotNull
	@Column(name = "jenis_bangunan", nullable = false)
	private String jenis_bangunan;

	@NotNull
	@Column(name = "status_order", nullable = false)
	private String status_order;

	@JsonIgnore
	@OneToOne(mappedBy = "id_order")
	private SurveiModel survei;

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

	public String getStatus_order() {
		return status_order;
	}

	public void setStatus_order(String status_order) {
		this.status_order = status_order;
	}

	public SurveiModel getSurvei() {
		return survei;
	}

	public void setSurvei(SurveiModel survei) {
		this.survei = survei;
	}
}
