package com.propensi.winscore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name= "kabkota")
public class KabKotaModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_kabkota;

	@OneToMany(mappedBy = "kabkota", fetch = FetchType.LAZY, cascade= CascadeType.PERSIST)
	private List<KecamatanModel> listKecamatan;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_provinsi", referencedColumnName="id_provinsi",nullable = false)
	@OnDelete(action= OnDeleteAction.NO_ACTION)
	@JsonIgnore
	private ProvinsiModel provinsi;
	
	@NotNull
	@Column(name = "nama", nullable = false)
	private String nama;

    public long getId_kabkota() {
        return id_kabkota;
    }

    public void setId_kabkota(long id_kabkota) {
        this.id_kabkota = id_kabkota;
    }

    public List<KecamatanModel> getListKecamatan() {
        return listKecamatan;
    }

    public void setListKecamatan(List<KecamatanModel> listKecamatan) {
        this.listKecamatan = listKecamatan;
    }

    public ProvinsiModel getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(ProvinsiModel provinsi) {
        this.provinsi = provinsi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
