package com.propensi.winscore.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name= "order")
public class OrderModel implements Serializable {
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
