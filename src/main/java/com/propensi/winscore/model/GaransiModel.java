package com.propensi.winscore.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name= "garansi")
public class GaransiModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_garansi;
	
	@NotNull
	@Column(name = "tgl_kadaluarsa", nullable = false)
	private Date tgl_kadaluarsa;

	public long getId_garansi() {
		return id_garansi;
	}

	public void setId_garansi(long id_garansi) {
		this.id_garansi = id_garansi;
	}

	public Date getTgl_kadaluarsa() {
		return tgl_kadaluarsa;
	}

	public void setTgl_kadaluarsa(Date tgl_kadaluarsa) {
		this.tgl_kadaluarsa = tgl_kadaluarsa;
	}
}
