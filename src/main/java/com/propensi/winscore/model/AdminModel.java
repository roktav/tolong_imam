package com.propensi.winscore.model;

import org.apache.tomcat.jni.User;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name= "admin")
public class AdminModel implements Serializable {
	@Id
	@OneToOne
	@JoinColumn(name = "id_admin",  referencedColumnName="id_user")
	private UserModel id_admin;
	
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

	public UserModel getId_admin() {
		return id_admin;
	}

	public void setId_admin(UserModel id_admin) {
		this.id_admin = id_admin;
	}

	public String getId_pegawai() {
		return id_pegawai;
	}

	public void setId_pegawai(String id_pegawai) {
		this.id_pegawai = id_pegawai;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getJabatan() {
		return jabatan;
	}

	public void setJabatan(String jabatan) {
		this.jabatan = jabatan;
	}

	public String getKantor_cabang() {
		return kantor_cabang;
	}

	public void setKantor_cabang(String kantor_cabang) {
		this.kantor_cabang = kantor_cabang;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
