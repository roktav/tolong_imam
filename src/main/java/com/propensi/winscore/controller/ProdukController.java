package com.propensi.winscore.controller;

import com.propensi.winscore.model.GaransiModel;
import com.propensi.winscore.model.ProdukModel;
import com.propensi.winscore.service.GaransiServiceImpl;
import com.propensi.winscore.service.ProdukService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.sql.Date;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api")
//@PreAuthorize("isAuthenticated()")
public class ProdukController {

    @Autowired
    @Qualifier("ProdukServiceImpl")
    private ProdukService produkService;

    @Autowired
    private GaransiServiceImpl garansiService;

    public void setProdukService(ProdukService produkService) {
        this.produkService = produkService;
    }

    @GetMapping(value="/list-produk")
    public BaseResponses<List<ProdukModel>> retrieveAllProduk() {
        BaseResponses<List<ProdukModel>> response = new BaseResponses<List<ProdukModel>>();
        List<ProdukModel> listProduk = produkService.findAll();
        if(listProduk != null) {
            response.setResult(listProduk);
            response.setMessage("Success");
            response.setStatus(200);
        } else {
            response.setStatus(404);
            response.setMessage("Not Found");
        }
        return response;
    }

    @GetMapping(value="/list-produk/detail-produk/{id_produk}")
    public BaseResponses<ProdukModel> retrieveDetailProduk(@PathVariable(value="id_produk") long id_produk) {
        BaseResponses<ProdukModel> response = new BaseResponses<ProdukModel>();
        ProdukModel detailProduk = produkService.getProdukById(id_produk);
        if(detailProduk != null) {
            response.setResult(detailProduk);
            response.setMessage("Success");
            response.setStatus(200);
        } else {
            response.setStatus(404);
            response.setMessage("Not Found");
        }
        return response;
    }

    @CrossOrigin
    @PostMapping("/list-produk/tambah-produk")
    public BaseResponses<ProdukModel> addProduk(@RequestBody Map<String, Object> getproduk) throws ParseException {
        BaseResponses<ProdukModel> response = new BaseResponses<>();
        ProdukModel produk = new ProdukModel();
        GaransiModel garansi = new GaransiModel();
        produk.setNama((String) getproduk.get("nama"));
        produk.setKode_produk((String) getproduk.get("kode_produk"));
        produk.setDetail_produk((String) getproduk.get("detail_produk"));
        produk.setStatus((String) getproduk.get("status"));
        produk.setHarga(Long.valueOf((String) getproduk.get("harga")));
        System.out.println(produk.getId_produk());
        //System.out.println(produk.toString());
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd MMM yyyy");
        java.util.Date date = sdf1.parse((String) getproduk.get("tgl_garansi"));
        Date tglKadaluarsa = new Date(date.getTime());
        garansi.setTgl_kadaluarsa(tglKadaluarsa);
        garansiService.addNewGaransi(garansi);
        produk.setId_garansi(garansi);
        ProdukModel newProduk = produkService.addNewProduk(produk);

        response.setStatus(200);
        response.setMessage("Success");
        response.setResult(newProduk);
        //produkService.addNewProduk(produk);
        return response;
    }

    @GetMapping(value="/ubah-detail-produk")
    private BaseResponses<ProdukModel> updateProduk(@RequestBody Map<String, Object> updateproduk, Long id_produk, Long id_garansi) throws ParseException {
        BaseResponses<ProdukModel> response = new BaseResponses<ProdukModel>();
        ProdukModel produk = produkService.getProdukById(id_produk);
        GaransiModel garansi = garansiService.getGaransiById(id_garansi);
        produk.setNama((String) updateproduk.get("nama"));
        produk.setKode_produk((String) updateproduk.get("kode_produk"));
        produk.setDetail_produk((String) updateproduk.get("detail_produk"));
        produk.setStatus((String) updateproduk.get("status"));
        produk.setHarga(Long.valueOf((String) updateproduk.get("harga")));
        System.out.println(produk.getId_produk());
        //System.out.println(produk.toString());
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd MMM yyyy");
        java.util.Date date = sdf1.parse((String) updateproduk.get("tgl_garansi"));
        Date tglKadaluarsa = new Date(date.getTime());
        garansi.setTgl_kadaluarsa(tglKadaluarsa);
        garansiService.addNewGaransi(garansi);
        produk.setId_garansi(garansi);
        ProdukModel ubahDetailProduk = produkService.updateProduk(produk);

        response.setStatus(200);
        response.setMessage("Success");
        response.setResult(ubahDetailProduk);
        //produkService.addNewProduk(produk);
        return response;
    }

}


class BaseResponses<T> {
    private int status;
    private String message;
    private T result;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
