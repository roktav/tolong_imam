package com.propensi.winscore.model;

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
	private List<KabKotaModel> listKabKota;

}
