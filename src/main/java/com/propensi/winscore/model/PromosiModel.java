package com.propensi.winscore.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name= "promosi")
public class PromosiModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_promosi;
	
	@NotNull
	@Column(name = "tgl_selesai", nullable = false)
	private Date tgl_mulai;
	
	@NotNull
	@Column(name = "tgl_selesai", nullable = false)
	private Date tgl_selesai;
	
}
