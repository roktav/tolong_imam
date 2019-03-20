package com.propensi.winscore.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name= "tagihan")
public class TagihanModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_tagihan;
	
	@NotNull
	@Column(name = "id_order", nullable = false)
	private long id_order;
	
	@NotNull
	@Column(name = "status", nullable = false)
	private String status;
	
	@NotNull
	@Column(name = "tgl_bayar", nullable = false)
	private String tgl_bayar;
	
	@NotNull
	@Column(name = "tgl_lunas", nullable = false)
	private String tgl_lunas;
}
