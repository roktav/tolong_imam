package com.propensi.winscore.model;

import com.propensi.winscore.model.audit.DateAudit;
import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name= "user")
public class UserModel extends DateAudit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_user;

	@NotNull
	@Column(name = "password", nullable = false)
	private String password;
	
	@NotNull
	@Column(name = "email", nullable = false)
	private String email;

	
	@NotNull
	@Column(name = "nama", nullable = false)
	private String nama;
	
	@NotNull
	@Column(name = "no_telp", nullable = false)
	private String no_telp;

	@NotNull
	@Column(name = "alamat", nullable = false)
	private String alamat;

    @NotNull
    @Column(name = "role", nullable = false)
    private String role;

    public UserModel(String nama, String password, String email, String no_telp, String alamat, String role){
        super();
        this.nama = nama;
        this.password = password;
        this.email = email;
        this.no_telp = no_telp;
        this.alamat = alamat;
        this.role = role;
    }

    public UserModel(){
        super();

    }

    public long getId_user() {
        return id_user;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
