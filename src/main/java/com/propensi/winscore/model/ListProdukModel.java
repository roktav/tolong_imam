package com.propensi.winscore.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name= "listproduk")
public class ListProdukModel implements Serializable {
    @EmbeddedId
    private ListProdukKey listProdukKey;

    @NotNull
    @Column(name = "jumlah_pesanan", nullable = false)
    private long jumlah_pesanan;

    public ListProdukKey getListProdukKey() {
        return listProdukKey;
    }

    public void setListProdukKey(ListProdukKey listProdukKey) {
        this.listProdukKey = listProdukKey;
    }

    public long getJumlah_pesanan() {
        return jumlah_pesanan;
    }

    public void setJumlah_pesanan(long jumlah_pesanan) {
        this.jumlah_pesanan = jumlah_pesanan;
    }
}
