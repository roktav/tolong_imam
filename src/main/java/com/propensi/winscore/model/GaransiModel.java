package com.propensi.winscore.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name= "garansi")
public class GaransiModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_garansi;
	
	@NotNull
	@Column(name = "tgl_kadaluarsa", nullable = false)
	private Date tgl_kadaluarsa;
	
}
