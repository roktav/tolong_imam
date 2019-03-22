package com.propensi.winscore.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name= "pembeli")
public class PembeliModel implements Serializable {
	@Id
	@OneToOne
	@JoinColumn(name = "id_pembeli",  referencedColumnName="id_user")
	private UserModel id_pembeli;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "id_kecamatan",  referencedColumnName="id_kecamatan")
	private KecamatanModel kecamatan;

	public UserModel getId_pembeli() {
		return id_pembeli;
	}

	public void setId_pembeli(UserModel id_pembeli) {
		this.id_pembeli = id_pembeli;
	}

	public KecamatanModel getKecamatan() {
		return kecamatan;
	}

	public void setKecamatan(KecamatanModel kecamatan) {
		this.kecamatan = kecamatan;
	}
}
