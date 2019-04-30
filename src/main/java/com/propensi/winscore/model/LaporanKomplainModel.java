package com.propensi.winscore.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name = "laporan_komplain")
public class LaporanKomplainModel {
    @Id
    private long id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "id_laporan",  referencedColumnName="id_laporan")
    private LaporanModel laporan;

    @OneToOne
    @JoinColumn(name = "id_komplain", referencedColumnName = "id_komplain")
    private KomplainModel komplain;

    @NotNull
    @Column(name = "tgl_perbaikan", nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date tgl_perbaikan;

}
