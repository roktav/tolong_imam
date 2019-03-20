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
}
