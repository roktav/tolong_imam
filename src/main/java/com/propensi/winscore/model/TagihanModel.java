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
	@OneToOne
	@JoinColumn(name = "id_order", referencedColumnName = "id_order")
	private OrderModel order;
	
	@NotNull
	@Column(name = "status", nullable = false)
	private String status;
	
	@NotNull
	@Column(name = "tgl_bayar", nullable = false)
	private String tgl_bayar;
	
	@NotNull
	@Column(name = "tgl_lunas", nullable = false)
	private String tgl_lunas;

    public long getId_tagihan() {
        return id_tagihan;
    }

    public void setId_tagihan(long id_tagihan) {
        this.id_tagihan = id_tagihan;
    }

    public OrderModel getOrder() {
        return order;
    }

    public void setOrder(OrderModel order) {
        this.order = order;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTgl_bayar() {
        return tgl_bayar;
    }

    public void setTgl_bayar(String tgl_bayar) {
        this.tgl_bayar = tgl_bayar;
    }

    public String getTgl_lunas() {
        return tgl_lunas;
    }

    public void setTgl_lunas(String tgl_lunas) {
        this.tgl_lunas = tgl_lunas;
    }
}
