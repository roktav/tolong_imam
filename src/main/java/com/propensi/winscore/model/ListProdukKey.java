package com.propensi.winscore.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Embeddable
public class ListProdukKey implements Serializable {
    @OneToOne
    @JoinColumn(name = "id_order", referencedColumnName = "id_order")
    private OrderModel order;

    @OneToOne
    @JoinColumn(name = "id_produk", referencedColumnName = "id_produk")
    private ProdukModel produk;

    public OrderModel getOrder() {
        return order;
    }

    public void setOrder(OrderModel order) {
        this.order = order;
    }

    public ProdukModel getProduk() {
        return produk;
    }

    public void setProduk(ProdukModel produk) {
        this.produk = produk;
    }
}
