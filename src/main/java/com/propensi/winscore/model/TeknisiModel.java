package com.propensi.winscore.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name= "teknisi")

public class TeknisiModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_teknisi;
	
	@NotNull
	@Column(name = "nama", nullable = false)
	private String nama;
	
	@NotNull
	@Column(name = "no_telp", nullable = false)
	private String no_telp;
	
	@NotNull
	@Column(name = "shift", nullable = false)
	private String shift;

	@NotNull
	@Column(name = "alamat", nullable = false)
	private String alamat;

    @NotNull
    @Column(name = "foto", nullable = false)
    private String foto;

	public long getId_teknisi() {
		return id_teknisi;
	}

	public void setId_teknisi(long id_teknisi) {
		this.id_teknisi = id_teknisi;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getNo_telp() {
		return no_telp;
	}

	public void setNo_telp(String no_telp) {
		this.no_telp = no_telp;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
}
