package com.propensi.winscore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "produk")
public class ProdukModel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_produk;

	@OneToOne
	@JoinColumn(name = "id_garansi", referencedColumnName = "id_garansi")
	private GaransiModel id_garansi;

	@OneToOne
	@JoinColumn(name = "id_promosi", referencedColumnName = "id_promosi")
	private PromosiModel id_promosi;

	@NotNull
	@Size(max = 50)
	@Column(name = "nama", nullable = false)
	private String nama;
	
	@NotNull
	@Size(max = 15)
	@Column(name = "kode_produk", nullable = false)
	private String kode_produk;

	@NotNull
	@Size(max = 100)
	@Column(name = "detail_produk", nullable = false)
	private String detail_produk;
	
	@NotNull
	@Size(max = 20)
	@Column(name = "status", nullable = false)
	private String status;
	
	@NotNull
	@Column(name = "harga", nullable = false)
	private Long harga;


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_order", referencedColumnName="id_order")
    @OnDelete(action= OnDeleteAction.NO_ACTION)
    @JsonIgnore
    private OrderModel order;

    @NotNull
    @Column(name="kategori_produk", nullable = false)
    private String kategori_produk;
<<<<<<< HEAD

    public String getKategori_produk() {
        return kategori_produk;
    }

    public void setKategori_produk(String kategori_produk) {
        this.kategori_produk = kategori_produk;
    }

    @NotNull
    @Column(name = "foto_produk", nullable = false)
    private String foto_produk;

    public String getFoto_produk() {
        return foto_produk;
    }

    public void setFoto_produk(String foto_produk) {
        this.foto_produk = foto_produk;
    }

=======

    public String getKategori_produk() {
        return kategori_produk;
    }

    public void setKategori_produk(String kategori_produk) {
        this.kategori_produk = kategori_produk;
    }

    /*@NotNull
        @Column(name = "foto_produk", nullable = false)
        private String foto_produk;

        public String getFoto_produk() {
            return foto_produk;
        }

        public void setFoto_produk(String foto_produk) {
            this.foto_produk = foto_produk;
        }
    */
>>>>>>> b14655a3a3e9ba98e8199efe3f71ed7211a569b7
    public long getId_produk() {
        return id_produk;
    }

    public void setId_produk(long id_produk) {
        this.id_produk = id_produk;
    }

    public GaransiModel getId_garansi() {
        return id_garansi;
    }

    public void setId_garansi(GaransiModel id_garansi) {
        this.id_garansi = id_garansi;
    }

    public PromosiModel getId_promosi() {
        return id_promosi;
    }

    public void setId_promosi(PromosiModel id_promosi) {
        this.id_promosi = id_promosi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKode_produk() {
        return kode_produk;
    }

    public void setKode_produk(String kode_produk) {
        this.kode_produk = kode_produk;
    }

    public String getDetail_produk() {
        return detail_produk;
    }

    public void setDetail_produk(String detail_produk) {
        this.detail_produk = detail_produk;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getHarga() {
        return harga;
    }

    public void setHarga(Long harga) {
        this.harga = harga;
    }

    public OrderModel getOrder() {
        return order;
    }

    public void setOrder(OrderModel order) {
        this.order = order;
    }
}
