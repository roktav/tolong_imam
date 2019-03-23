package com.propensi.winscore.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name= "promosi")
public class PromosiModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_promosi;
	
	@NotNull
	@Column(name = "tgl_mulai", nullable = false)
	private Date tgl_mulai;
	
	@NotNull
	@Column(name = "tgl_selesai", nullable = false)
	private Date tgl_selesai;

	public long getId_promosi() {
		return id_promosi;
	}

	public void setId_promosi(long id_promosi) {
		this.id_promosi = id_promosi;
	}

	public Date getTgl_mulai() {
		return tgl_mulai;
	}

	public void setTgl_mulai(Date tgl_mulai) {
		this.tgl_mulai = tgl_mulai;
	}

	public Date getTgl_selesai() {
		return tgl_selesai;
	}

	public void setTgl_selesai(Date tgl_selesai) {
		this.tgl_selesai = tgl_selesai;
	}
}
