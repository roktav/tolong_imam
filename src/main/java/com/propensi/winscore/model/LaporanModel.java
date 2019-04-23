package com.propensi.winscore.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.criterion.Order;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name= "laporan")
public class LaporanModel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_laporan;

	@NotNull
	@OneToOne
	@JoinColumn(name = "id_order", referencedColumnName = "id_order")
	private OrderModel order;
	
	@NotNull
	@Column(name = "deskripsi", nullable = false)
	private String deskripsi;

	@NotNull
	@Column(name = "tgl_laporan", nullable = false)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date tgl_laporan;

}
