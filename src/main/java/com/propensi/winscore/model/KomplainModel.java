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
	@Column(name = "id_pembeli", nullable = false)
	private long id_pembeli;
	
	@NotNull
	@Column(name = "id_produk", nullable = false)
	private long id_produk;
	
	@NotNull
	@Column(name = "tgl_komplain", nullable = false)
	private Date tgl_komplain;
	
	@NotNull
	@Column(name = "jenis", nullable = false)
	private String jenis;
	
	@NotNull
	@Column(name = "deskripsi", nullable = false)
	private String deskripsi;

}
