package com.propensi.winscore.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "survei")
public class SurveiModel implements Serializable {
    @Id
    private long id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "id_order",  referencedColumnName="id_order")
    private OrderModel id_order;

    @NotNull
    @Column(name = "tanggal_survei", nullable = false)
    private Date tanggal_survei;

    @NotNull
    @Column(name = "waktu_survei", nullable = false)
    private Time waktu_survei;

    @NotNull
    @Column(name = "alamat_survei", nullable = false)
    private String alamat_survei;

    @Column(name = "keterangan")
    private String keterangan;

    @OneToOne
    @JoinColumn(name = "id_teknisi", referencedColumnName = "id_teknisi")
    private TeknisiModel id_teknisi;

    public OrderModel getId_order() {
        return id_order;
    }

    public void setId_order(OrderModel id_order) {
        this.id_order = id_order;
    }

    public String getAlamat_survei() {
        return alamat_survei;
    }

    public void setAlamat_survei(String alamat_survei) {
        this.alamat_survei = alamat_survei;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public TeknisiModel getId_teknisi() {
        return id_teknisi;
    }

    public void setId_teknisi(TeknisiModel id_teknisi) {
        this.id_teknisi = id_teknisi;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getTanggal_survei() {
        return tanggal_survei;
    }

    public void setTanggal_survei(Date tanggal_survei) {
        this.tanggal_survei = tanggal_survei;
    }

    public Time getWaktu_survei() {
        return waktu_survei;
    }

    public void setWaktu_survei(Time waktu_survei) {
        this.waktu_survei = waktu_survei;
    }
}
