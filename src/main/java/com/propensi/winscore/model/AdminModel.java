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
@Table(name= "admin")
public class AdminModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_admin;
	
	@NotNull
	@Column(name = "id_pegawai", nullable = false)
	private String id_pegawai;
	
	@NotNull
	@Column(name = "username", nullable = false)
	private String username;
	
	@NotNull
	@Column(name = "role", nullable = false)
	private String role;
	
	@NotNull
	@Column(name = "jabatan", nullable = false)
	private String jabatan;
	
	@NotNull
	@Column(name = "kantor_cabang", nullable = false)
	private String kantor_cabang;
	
	@NotNull
	@Column(name = "status", nullable = false)
	private String status;
}
