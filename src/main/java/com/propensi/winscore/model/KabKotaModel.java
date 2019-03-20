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
	@JoinColumn(name="id_provinsi", referencedColumnName="id",nullable = false)
	@OnDelete(action= OnDeleteAction.NO_ACTION)
	@JsonIgnore
	private ProvinsiModel provinsi;
	
	@NotNull
	@Column(name = "nama", nullable = false)
	private String nama;

}
