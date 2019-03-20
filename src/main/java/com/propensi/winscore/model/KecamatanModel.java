package com.propensi.winscore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name= "kecamatan")
public class KecamatanModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_kecamatan;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_kabkota", referencedColumnName="id",nullable = false)
    @OnDelete(action= OnDeleteAction.NO_ACTION)
    @JsonIgnore
    private KabKotaModel kabkota;

	@NotNull
	@Column(name = "nama", nullable = false)
	private String nama;

	@NotNull
	@Column(name = "status", nullable = false)
	private String status;

}
