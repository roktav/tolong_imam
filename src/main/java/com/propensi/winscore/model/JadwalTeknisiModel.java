package com.propensi.winscore.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name= "jadwalteknisi")
public class JadwalTeknisiModel implements Serializable {
	@Id
	@OneToOne
	@JoinColumn(name = "id_teknisi")
	private TeknisiModel id_teknisi;

	@NotNull
	@Column(name = "bulan", nullable = false)
	private String bulan;
	
	@NotNull
	@Column(name = "minggu", nullable = false)
	private String minggu;
	
	@NotNull
	@Column(name = "shift", nullable = false)
	private String shift;

}
