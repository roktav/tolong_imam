package com.propensi.winscore.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name = "laporan_survei")
public class LaporanSurveiModel {
    @Id
    private long id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "id_laporan",  referencedColumnName="id_laporan")
    private LaporanModel laporan;

    @NotNull
    @Column(name = "tgl_survei", nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date tgl_survei;

    @NotNull
    @Column(name = "total_harga")
    private long total_harga;

}
