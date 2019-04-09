package com.propensi.winscore.model;



import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name= "komplain")
public class KomplainModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_komplain;

	@NotNull
	@OneToOne
	@JoinColumn(name = "id_pembeli", referencedColumnName = "id_pembeli")
	private PembeliModel pembeli;

	@OneToOne
	@JoinColumn(name = "id_produk", referencedColumnName = "id_produk")
	private ProdukModel produk;
	
	@NotNull
	@Column(name = "tgl_komplain", nullable = false)
	private Date tgl_komplain;
	
	@NotNull
	@Column(name = "jenis", nullable = false)
	private String jenis;
	
	@NotNull
	@Column(name = "deskripsi", nullable = false)
	private String deskripsi;

	public long getId_komplain() {
		return id_komplain;
	}

	public void setId_komplain(long id_komplain) {
		this.id_komplain = id_komplain;
	}

	public PembeliModel getPembeli() {
		return pembeli;
	}

	public void setPembeli(PembeliModel pembeli) {
		this.pembeli = pembeli;
	}

	public ProdukModel getProduk() {
		return produk;
	}

	public void setProduk(ProdukModel produk) {
		this.produk = produk;
	}

	public Date getTgl_komplain() {
		return tgl_komplain;
	}

	public void setTgl_komplain(Date tgl_komplain) {
		this.tgl_komplain = tgl_komplain;
	}

	public String getJenis() {
		return jenis;
	}

	public void setJenis(String jenis) {
		this.jenis = jenis;
	}

	public String getDeskripsi() {
		return deskripsi;
	}

	public void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}
}
