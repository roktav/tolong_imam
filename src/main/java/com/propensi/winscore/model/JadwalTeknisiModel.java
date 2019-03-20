package com.propensi.winscore.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name= "jadwalteknisi")
public class JadwalTeknisiModel implements Serializable {
	@Id
	@OneToOne
	@JoinColumn(name = "id_teknisi", referencedColumnName = "id_teknisi")
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

    public TeknisiModel getId_teknisi() {
        return id_teknisi;
    }

    public void setId_teknisi(TeknisiModel id_teknisi) {
        this.id_teknisi = id_teknisi;
    }

    public String getBulan() {
        return bulan;
    }

    public void setBulan(String bulan) {
        this.bulan = bulan;
    }

    public String getMinggu() {
        return minggu;
    }

    public void setMinggu(String minggu) {
        this.minggu = minggu;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }
}
