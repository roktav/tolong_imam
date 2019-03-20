package com.propensi.winscore.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name= "pembeli")
public class PembeliModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_pembeli;
	
	@NotNull
	@Column(name = "id_kecamatan", nullable = false)
	private String id_kecamatan;

}
