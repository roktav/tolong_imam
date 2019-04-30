package com.propensi.winscore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name= "provinsi")
public class ProvinsiModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_provinsi;
	
	@NotNull
	@Column(name = "nama", nullable = false)
	private String nama;

	@OneToMany(mappedBy = "provinsi", fetch = FetchType.LAZY, cascade= CascadeType.PERSIST)
	@JsonIgnore
    private List<KabKotaModel> listKabKota;

    public long getId_provinsi() {
        return id_provinsi;
    }

    public void setId_provinsi(long id_provinsi) {
        this.id_provinsi = id_provinsi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public List<KabKotaModel> getListKabKota() {
        return listKabKota;
    }

    public void setListKabKota(List<KabKotaModel> listKabKota) {
        this.listKabKota = listKabKota;
    }
}
